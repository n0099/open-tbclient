package com.baidu.tieba;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.BdCloseHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes8.dex */
public class xv4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public c b;
    public final Context c;
    public int d;
    public String[] e;
    public String[] f;
    public HashMap<String, sv4> g;

    /* loaded from: classes8.dex */
    public class a implements Comparator<MediaFileInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(xv4 xv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(MediaFileInfo mediaFileInfo, MediaFileInfo mediaFileInfo2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mediaFileInfo, mediaFileInfo2)) == null) {
                int i = ((mediaFileInfo2.getSortTime() - mediaFileInfo.getSortTime()) > 0L ? 1 : ((mediaFileInfo2.getSortTime() - mediaFileInfo.getSortTime()) == 0L ? 0 : -1));
                if (i == 0) {
                    return 0;
                }
                if (i > 0) {
                    return 1;
                }
                return -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Comparator<sv4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xv4 a;

        public b(xv4 xv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xv4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(sv4 sv4Var, sv4 sv4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sv4Var, sv4Var2)) == null) {
                if (this.a.a.equals(sv4Var.g())) {
                    return -1;
                }
                if (this.a.a.equals(sv4Var2.g())) {
                    return 1;
                }
                int i = ((sv4Var2.e().getSortTime() - sv4Var.e().getSortTime()) > 0L ? 1 : ((sv4Var2.e().getSortTime() - sv4Var.e().getSortTime()) == 0L ? 0 : -1));
                if (i == 0) {
                    return 0;
                }
                if (i <= 0) {
                    return -1;
                }
                return 1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<Object, Integer, yv4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final wv4 a;
        public final /* synthetic */ xv4 b;

        public c(xv4 xv4Var, wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xv4Var, wv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xv4Var;
            this.a = wv4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public yv4 doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                return this.b.d();
            }
            return (yv4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(yv4 yv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yv4Var) == null) {
                super.onPostExecute(yv4Var);
                wv4 wv4Var = this.a;
                if (wv4Var != null) {
                    wv4Var.a(yv4Var);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onPreExecute();
                wv4 wv4Var = this.a;
                if (wv4Var != null) {
                    wv4Var.onPreLoad();
                }
            }
        }
    }

    public xv4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = TbConfig.getTempDirName();
        this.d = 0;
        this.e = new String[]{"_id", "bucket_id", "bucket_display_name", "_data", "mime_type", "date_added", "_size", "date_modified"};
        this.f = new String[]{"_id", "_data", "title", "mime_type", "_display_name", "duration", "datetaken", "date_modified", "date_added"};
        this.g = new HashMap<>();
        this.c = context;
    }

    public void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (cVar = this.b) != null) {
            cVar.cancel();
            this.b = null;
        }
    }

    public List<ImageFileInfo> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<ImageFileInfo> f = f(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (f != null) {
                arrayList.addAll(f);
            }
            List<ImageFileInfo> f2 = f(MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            if (f2 != null) {
                arrayList.addAll(f2);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final yv4 d() {
        InterceptResult invokeV;
        List<ImageFileInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.g.clear();
            yv4 yv4Var = new yv4();
            List<VideoFileInfo> list2 = null;
            if (this.d != 1) {
                list = e();
            } else {
                list = null;
            }
            int i = this.d;
            if (i != 2 && i != 3 && i != 4) {
                list2 = g();
            }
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                arrayList.addAll(list);
            }
            if (!ListUtils.isEmpty(list2)) {
                arrayList.addAll(list2);
            }
            if (!ListUtils.isEmpty(arrayList)) {
                Collections.sort(arrayList, new a(this));
            }
            ArrayList arrayList2 = new ArrayList(this.g.values());
            if (!ListUtils.isEmpty(arrayList2)) {
                Collections.sort(arrayList2, new b(this));
            }
            yv4Var.a = arrayList2;
            yv4Var.c = list2;
            yv4Var.b = arrayList;
            return yv4Var;
        }
        return (yv4) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009f, code lost:
        if (r12 > 3145728) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0122 A[LOOP:0: B:12:0x002c->B:48:0x0122, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x013a A[EDGE_INSN: B:80:0x013a->B:61:0x013a ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ImageFileInfo> f(Uri uri) {
        InterceptResult invokeL;
        Cursor cursor;
        ArrayList arrayList;
        Cursor cursor2;
        String str;
        ArrayList arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uri)) == null) {
            String str2 = null;
            if (this.c == null) {
                return null;
            }
            ArrayList arrayList3 = new ArrayList();
            try {
                cursor2 = this.c.getContentResolver().query(uri, this.e, "mime_type like 'image/%'", null, "date_added DESC");
            } catch (Exception e) {
                e = e;
                arrayList = arrayList3;
                cursor2 = null;
            } catch (Throwable th) {
                th = th;
                cursor = null;
                BdCloseHelper.close(cursor);
                throw th;
            }
            if (cursor2 != null) {
                try {
                    try {
                    } catch (Exception e2) {
                        e = e2;
                        arrayList = arrayList3;
                    }
                    if (cursor2.moveToFirst()) {
                        while (true) {
                            Uri withAppendedId = ContentUris.withAppendedId(uri, cursor2.getLong(cursor2.getColumnIndex("_id")));
                            if (withAppendedId != null) {
                                str = withAppendedId.toString();
                            } else {
                                str = str2;
                            }
                            String string = cursor2.getString(cursor2.getColumnIndex("bucket_id"));
                            String string2 = cursor2.getString(cursor2.getColumnIndex("bucket_display_name"));
                            String string3 = cursor2.getString(cursor2.getColumnIndex("_data"));
                            String string4 = cursor2.getString(cursor2.getColumnIndex("mime_type"));
                            long j = cursor2.getLong(cursor2.getColumnIndex("date_added"));
                            int i = cursor2.getInt(cursor2.getColumnIndex("_size"));
                            long j2 = cursor2.getLong(cursor2.getColumnIndex("date_modified"));
                            boolean endsWith = string4.endsWith(NativeConstants.TYPE_GIF);
                            try {
                                if (endsWith) {
                                    if (this.d != 3) {
                                        arrayList2 = arrayList3;
                                    } else {
                                        arrayList = arrayList3;
                                        if (!cursor2.moveToNext()) {
                                            break;
                                        }
                                        arrayList3 = arrayList;
                                        str2 = null;
                                    }
                                } else {
                                    arrayList2 = arrayList3;
                                }
                                if (this.d == 4 && !string4.endsWith("jpeg") && !string4.endsWith("png")) {
                                    arrayList = arrayList2;
                                    if (!cursor2.moveToNext()) {
                                    }
                                } else {
                                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                                    imageFileInfo.setAlbumnId(string);
                                    imageFileInfo.setContentUriStr(str);
                                    imageFileInfo.setFilePath(string3);
                                    imageFileInfo.setIsGif(endsWith);
                                    imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(j2));
                                    imageFileInfo.setSortTime(j);
                                    arrayList = arrayList2;
                                    try {
                                        arrayList.add(imageFileInfo);
                                        sv4 sv4Var = this.g.get(string);
                                        if (sv4Var == null) {
                                            sv4Var = new sv4();
                                            this.g.put(string, sv4Var);
                                        }
                                        sv4Var.h(string);
                                        sv4Var.l(string2);
                                        sv4Var.a();
                                        if (sv4Var.e() == null) {
                                            sv4Var.k(imageFileInfo);
                                        }
                                        List<MediaFileInfo> d = sv4Var.d();
                                        if (sv4Var.d() == null) {
                                            d = new ArrayList<>();
                                            sv4Var.j(d);
                                        }
                                        d.add(imageFileInfo);
                                        if (!cursor2.moveToNext()) {
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        BdLog.detailException(e);
                                        BdCloseHelper.close(cursor2);
                                        return arrayList;
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                                arrayList = arrayList2;
                                BdLog.detailException(e);
                                BdCloseHelper.close(cursor2);
                                return arrayList;
                            }
                        }
                        BdCloseHelper.close(cursor2);
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                    BdCloseHelper.close(cursor);
                    throw th;
                }
            }
            arrayList = arrayList3;
            BdCloseHelper.close(cursor2);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final List<VideoFileInfo> g() {
        InterceptResult invokeV;
        Cursor cursor;
        Cursor cursor2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Context context = this.c;
            if (context == null) {
                return arrayList;
            }
            ContentResolver contentResolver = context.getContentResolver();
            HashSet hashSet = new HashSet();
            try {
                Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                Cursor query = contentResolver.query(uri, this.f, null, null, "date_added DESC");
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            while (true) {
                                int i = query.getInt(query.getColumnIndex("_id"));
                                Uri withAppendedId = ContentUris.withAppendedId(uri, i);
                                if (withAppendedId != null) {
                                    str = withAppendedId.toString();
                                } else {
                                    str = null;
                                }
                                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                                String string2 = query.getString(query.getColumnIndexOrThrow("title"));
                                String string3 = query.getString(query.getColumnIndexOrThrow("_display_name"));
                                String string4 = query.getString(query.getColumnIndexOrThrow("mime_type"));
                                int i2 = query.getInt(query.getColumnIndexOrThrow("duration"));
                                long j = query.getLong(query.getColumnIndexOrThrow("date_modified"));
                                Uri uri2 = uri;
                                long j2 = query.getLong(query.getColumnIndexOrThrow("date_added"));
                                if (i2 > 1 && !hashSet.contains(string)) {
                                    hashSet.add(string);
                                    File file = new File(string);
                                    if (file.exists() && file.isFile() && zh.u(file) > 0) {
                                        VideoFileInfo videoFileInfo = new VideoFileInfo();
                                        videoFileInfo.videoId = i;
                                        videoFileInfo.contentUriStr = str;
                                        videoFileInfo.videoPath = string;
                                        videoFileInfo.displayName = string3;
                                        videoFileInfo.title = string2;
                                        videoFileInfo.mimeType = string4;
                                        videoFileInfo.videoDuration = i2;
                                        videoFileInfo.lastModified = j;
                                        videoFileInfo.setSortTime(j2);
                                        arrayList.add(videoFileInfo);
                                    }
                                }
                                if (!query.moveToNext()) {
                                    break;
                                }
                                uri = uri2;
                            }
                        }
                    } catch (Exception unused) {
                        cursor2 = query;
                        BdCloseHelper.close(cursor2);
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        BdCloseHelper.close(cursor);
                        throw th;
                    }
                }
                BdCloseHelper.close(query);
            } catch (Exception unused2) {
                cursor2 = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public boolean h(int i, wv4 wv4Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, wv4Var)) == null) {
            if (wv4Var == null) {
                return false;
            }
            c();
            this.d = i;
            c cVar = new c(this, wv4Var);
            this.b = cVar;
            cVar.setPriority(3);
            this.b.execute(new Object[0]);
            return true;
        }
        return invokeIL.booleanValue;
    }
}
