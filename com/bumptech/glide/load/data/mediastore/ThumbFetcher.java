package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class ThumbFetcher implements DataFetcher<InputStream> {
    public static final String TAG = "MediaStoreThumbFetcher";
    public InputStream inputStream;
    public final Uri mediaStoreImageUri;
    public final ThumbnailStreamOpener opener;

    /* loaded from: classes6.dex */
    public static class ImageThumbnailQuery implements ThumbnailQuery {
        public static final String[] PATH_PROJECTION = {"_data"};
        public static final String PATH_SELECTION = "kind = 1 AND image_id = ?";
        public final ContentResolver contentResolver;

        public ImageThumbnailQuery(ContentResolver contentResolver) {
            this.contentResolver = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri uri) {
            return this.contentResolver.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* loaded from: classes6.dex */
    public static class VideoThumbnailQuery implements ThumbnailQuery {
        public static final String[] PATH_PROJECTION = {"_data"};
        public static final String PATH_SELECTION = "kind = 1 AND video_id = ?";
        public final ContentResolver contentResolver;

        public VideoThumbnailQuery(ContentResolver contentResolver) {
            this.contentResolver = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri uri) {
            return this.contentResolver.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    public ThumbFetcher(Uri uri, ThumbnailStreamOpener thumbnailStreamOpener) {
        this.mediaStoreImageUri = uri;
        this.opener = thumbnailStreamOpener;
    }

    public static ThumbFetcher build(Context context, Uri uri, ThumbnailQuery thumbnailQuery) {
        return new ThumbFetcher(uri, new ThumbnailStreamOpener(Glide.get(context).getRegistry().getImageHeaderParsers(), thumbnailQuery, Glide.get(context).getArrayPool(), context.getContentResolver()));
    }

    public static ThumbFetcher buildImageFetcher(Context context, Uri uri) {
        return build(context, uri, new ImageThumbnailQuery(context.getContentResolver()));
    }

    public static ThumbFetcher buildVideoFetcher(Context context, Uri uri) {
        return build(context, uri, new VideoThumbnailQuery(context.getContentResolver()));
    }

    private InputStream openThumbInputStream() throws FileNotFoundException {
        InputStream open = this.opener.open(this.mediaStoreImageUri);
        int orientation = open != null ? this.opener.getOrientation(this.mediaStoreImageUri) : -1;
        return orientation != -1 ? new ExifOrientationStream(open, orientation) : open;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        try {
            InputStream openThumbInputStream = openThumbInputStream();
            this.inputStream = openThumbInputStream;
            dataCallback.onDataReady(openThumbInputStream);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to find thumbnail file", e2);
            }
            dataCallback.onLoadFailed(e2);
        }
    }
}
