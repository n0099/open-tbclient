package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes14.dex */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "LocalUriFetcher";
    private final ContentResolver contentResolver;
    private T data;
    private final Uri uri;

    protected abstract void close(T t) throws IOException;

    protected abstract T loadResource(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this.contentResolver = contentResolver;
        this.uri = uri;
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: T, ? super T */
    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            this.data = loadResource(this.uri, this.contentResolver);
            dataCallback.onDataReady((T) this.data);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to open Uri", e);
            }
            dataCallback.onLoadFailed(e);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        if (this.data != null) {
            try {
                close(this.data);
            } catch (IOException e) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}
