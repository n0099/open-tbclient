package com.baidu.tieba;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
/* loaded from: classes4.dex */
public class lo4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public c b;
    public final Context c;
    public int d;
    public String[] e;
    public String[] f;
    public HashMap g;

    /* loaded from: classes4.dex */
    public class a implements Comparator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(lo4 lo4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lo4Var};
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

    /* loaded from: classes4.dex */
    public class b implements Comparator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lo4 a;

        public b(lo4 lo4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lo4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lo4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(go4 go4Var, go4 go4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, go4Var, go4Var2)) == null) {
                if (this.a.a.equals(go4Var.g())) {
                    return -1;
                }
                if (this.a.a.equals(go4Var2.g())) {
                    return 1;
                }
                int i = ((go4Var2.e().getSortTime() - go4Var.e().getSortTime()) > 0L ? 1 : ((go4Var2.e().getSortTime() - go4Var.e().getSortTime()) == 0L ? 0 : -1));
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

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ko4 a;
        public final /* synthetic */ lo4 b;

        public c(lo4 lo4Var, ko4 ko4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lo4Var, ko4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lo4Var;
            this.a = ko4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public mo4 doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                return this.b.d();
            }
            return (mo4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(mo4 mo4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mo4Var) == null) {
                super.onPostExecute(mo4Var);
                ko4 ko4Var = this.a;
                if (ko4Var != null) {
                    ko4Var.a(mo4Var);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onPreExecute();
                ko4 ko4Var = this.a;
                if (ko4Var != null) {
                    ko4Var.onPreLoad();
                }
            }
        }
    }

    public lo4(Context context) {
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
        this.g = new HashMap();
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

    public List e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List f = f(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (f != null) {
                arrayList.addAll(f);
            }
            List f2 = f(MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            if (f2 != null) {
                arrayList.addAll(f2);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final mo4 d() {
        InterceptResult invokeV;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.g.clear();
            mo4 mo4Var = new mo4();
            List list2 = null;
            if (this.d != 1) {
                list = e();
            } else {
                list = null;
            }
            int i = this.d;
            if (i != 2 && i != 3) {
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
            mo4Var.a = arrayList2;
            mo4Var.c = list2;
            mo4Var.b = arrayList;
            return mo4Var;
        }
        return (mo4) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0104 A[LOOP:0: B:12:0x002c->B:38:0x0104, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0115 A[EDGE_INSN: B:70:0x0115->B:47:0x0115 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List f(Uri uri) {
        InterceptResult invokeL;
        Cursor cursor;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uri)) == null) {
            lo4 lo4Var = this;
            String str2 = null;
            if (lo4Var.c == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                Cursor query = lo4Var.c.getContentResolver().query(uri, lo4Var.e, "mime_type like 'image/%'", null, "date_added DESC");
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            while (true) {
                                Uri withAppendedId = ContentUris.withAppendedId(uri, query.getLong(query.getColumnIndex("_id")));
                                if (withAppendedId != null) {
                                    str = withAppendedId.toString();
                                } else {
                                    str = str2;
                                }
                                String string = query.getString(query.getColumnIndex("bucket_id"));
                                String string2 = query.getString(query.getColumnIndex("bucket_display_name"));
                                String string3 = query.getString(query.getColumnIndex("_data"));
                                String string4 = query.getString(query.getColumnIndex("mime_type"));
                                long j = query.getLong(query.getColumnIndex("date_added"));
                                int i = query.getInt(query.getColumnIndex("_size"));
                                long j2 = query.getLong(query.getColumnIndex("date_modified"));
                                boolean endsWith = string4.endsWith(NativeConstants.TYPE_GIF);
                                if (endsWith) {
                                    try {
                                        if (lo4Var.d == 3 || i > 3145728) {
                                            lo4Var = this;
                                            if (query.moveToNext()) {
                                                break;
                                            }
                                            str2 = null;
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        cursor = query;
                                        try {
                                            BdLog.detailException(e);
                                            dh.a(cursor);
                                            return arrayList;
                                        } catch (Throwable th) {
                                            th = th;
                                            dh.a(cursor);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        cursor = query;
                                        dh.a(cursor);
                                        throw th;
                                    }
                                }
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                imageFileInfo.setAlbumnId(string);
                                imageFileInfo.setContentUriStr(str);
                                imageFileInfo.setFilePath(string3);
                                imageFileInfo.setIsGif(endsWith);
                                imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(j2));
                                imageFileInfo.setSortTime(j);
                                arrayList.add(imageFileInfo);
                                lo4Var = this;
                                go4 go4Var = (go4) lo4Var.g.get(string);
                                if (go4Var == null) {
                                    go4Var = new go4();
                                    lo4Var.g.put(string, go4Var);
                                }
                                go4Var.h(string);
                                go4Var.l(string2);
                                go4Var.a();
                                if (go4Var.e() == null) {
                                    go4Var.k(imageFileInfo);
                                }
                                List d = go4Var.d();
                                if (go4Var.d() == null) {
                                    d = new ArrayList();
                                    go4Var.j(d);
                                }
                                d.add(imageFileInfo);
                                if (query.moveToNext()) {
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                dh.a(query);
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th4) {
                th = th4;
                cursor = null;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final List g() {
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
                                    if (file.exists() && file.isFile() && aj.u(file) > 0) {
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
                        dh.a(cursor2);
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        cursor = query;
                        dh.a(cursor);
                        throw th;
                    }
                }
                dh.a(query);
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

    public boolean h(int i, ko4 ko4Var) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, ko4Var)) == null) {
            if (ko4Var == null) {
                return false;
            }
            c();
            this.d = i;
            c cVar = new c(this, ko4Var);
            this.b = cVar;
            cVar.setPriority(3);
            this.b.execute(new Object[0]);
            return true;
        }
        return invokeIL.booleanValue;
    }
}
