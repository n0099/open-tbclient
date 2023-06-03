package com.baidu.tieba;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class tw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public a b;
    public c c;
    public final Context d;

    /* loaded from: classes8.dex */
    public interface b {
        void a(List<ImageFileInfo> list);
    }

    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<Void, List<ImageFileInfo>, List<ImageFileInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final vw4 a;
        public final String b;
        public String c;
        public List<sw4> d;
        public int e;
        public b f;
        public final /* synthetic */ tw4 g;

        /* loaded from: classes8.dex */
        public class a implements b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tieba.tw4.b
            public void a(List<ImageFileInfo> list) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, list) != null) {
                    return;
                }
                this.a.publishProgress(list);
            }
        }

        public c(tw4 tw4Var, String str, vw4 vw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tw4Var, str, vw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = tw4Var;
            this.e = 1;
            this.f = new a(this);
            this.a = vw4Var;
            this.b = str;
        }

        public final void e(List<ImageFileInfo> list, b bVar, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLL(1048579, this, list, bVar, str) != null) || list == null) {
                return;
            }
            d(list, bVar, str, this.g.d, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (list != null && list.size() > 0) {
                return;
            }
            d(list, bVar, str, this.g.d, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public List<ImageFileInfo> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                if (TextUtils.isEmpty(this.b)) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                if (this.b.equals(sw4.f)) {
                    List<sw4> f = this.g.f();
                    this.d = f;
                    if (f != null) {
                        for (sw4 sw4Var : f) {
                            String b = sw4Var.b();
                            if (!TextUtils.isEmpty(b)) {
                                e(arrayList, this.f, b);
                            }
                        }
                    }
                    return arrayList;
                }
                e(arrayList, this.f, this.b);
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        public final void d(List<ImageFileInfo> list, b bVar, String str, Context context, Uri uri) {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, bVar, str, context, uri) != null) || list == null) {
                return;
            }
            Cursor cursor = null;
            String str2 = null;
            cursor = null;
            try {
                Cursor query = context.getContentResolver().query(uri, new String[]{"_id", "bucket_id", "_data", "bucket_display_name"}, "bucket_id=?", new String[]{str}, "datetaken DESC");
                try {
                    if (query.moveToFirst()) {
                        int columnIndex = query.getColumnIndex("_data");
                        int columnIndex2 = query.getColumnIndex("bucket_display_name");
                        Uri withAppendedId = ContentUris.withAppendedId(uri, query.getLong(query.getColumnIndex("_id")));
                        if (withAppendedId != null) {
                            str2 = withAppendedId.toString();
                        }
                        do {
                            String string = query.getString(columnIndex);
                            try {
                                this.c = query.getString(columnIndex2);
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                imageFileInfo.setAlbumnId(str);
                                imageFileInfo.setContentUriStr(str2);
                                imageFileInfo.setFilePath(string);
                                File file = new File(string);
                                if (file.exists() && file.isFile() && file.length() > 0) {
                                    if (string.toLowerCase().endsWith(".gif") && FileHelper.isGifImage(string)) {
                                        if (qi.u(file) <= 3145728) {
                                            z = true;
                                        }
                                    } else if (FileHelper.checkIsLongImage(string)) {
                                        z = false;
                                        z2 = true;
                                        imageFileInfo.setIsGif(z);
                                        imageFileInfo.setIsLong(z2);
                                        imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(file.lastModified()));
                                        list.add(imageFileInfo);
                                        f(list, bVar);
                                    } else {
                                        z = false;
                                    }
                                    z2 = false;
                                    imageFileInfo.setIsGif(z);
                                    imageFileInfo.setIsLong(z2);
                                    imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(file.lastModified()));
                                    list.add(imageFileInfo);
                                    f(list, bVar);
                                }
                            } catch (Exception e) {
                                e = e;
                                cursor = query;
                                try {
                                    BdLog.detailException(e);
                                    sg.a(cursor);
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    sg.a(cursor);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = query;
                                sg.a(cursor);
                                throw th;
                            }
                        } while (query.moveToNext());
                    }
                    sg.a(query);
                } catch (Exception e2) {
                    e = e2;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e3) {
                e = e3;
            } catch (Throwable th4) {
                th = th4;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public void onPostExecute(List<ImageFileInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
                super.onPostExecute(list);
                vw4 vw4Var = this.a;
                if (vw4Var != null) {
                    vw4Var.a(this.d, list, this.c);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public void onProgressUpdate(List<ImageFileInfo>... listArr) {
            vw4 vw4Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, listArr) == null) {
                super.onProgressUpdate(listArr);
                if (listArr.length > 0 && (vw4Var = this.a) != null) {
                    vw4Var.a(this.d, listArr[0], this.c);
                }
            }
        }

        public final void f(List<ImageFileInfo> list, b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048580, this, list, bVar) == null) && list != null && bVar != null) {
                int i = this.e;
                if (i != 1 && i != 2) {
                    if (list.size() / this.e > 500) {
                        if (bVar != null) {
                            bVar.a(list);
                        }
                        this.e++;
                    }
                } else if (list.size() / this.e > 50) {
                    if (bVar != null) {
                        bVar.a(list);
                    }
                    this.e++;
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                super.onPreCancel();
                vw4 vw4Var = this.a;
                if (vw4Var != null) {
                    vw4Var.onPreLoad();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, List<sw4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final uw4 a;
        public final /* synthetic */ tw4 b;

        public a(tw4 tw4Var, uw4 uw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tw4Var, uw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tw4Var;
            this.a = uw4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<sw4> doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                return this.b.f();
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<sw4> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                super.onPostExecute(list);
                uw4 uw4Var = this.a;
                if (uw4Var != null) {
                    uw4Var.a(list);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onPreExecute();
                uw4 uw4Var = this.a;
                if (uw4Var != null) {
                    uw4Var.onPreLoad();
                }
            }
        }
    }

    public tw4(Context context) {
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
        this.d = context;
    }

    public boolean g(uw4 uw4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, uw4Var)) == null) {
            if (uw4Var == null) {
                return false;
            }
            c();
            a aVar = new a(this, uw4Var);
            this.b = aVar;
            aVar.setPriority(3);
            this.b.execute(new Object[0]);
            return true;
        }
        return invokeL.booleanValue;
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            String h = h(str);
            if (h != null) {
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(h.toLowerCase(Locale.getDefault()));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void c() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (aVar = this.b) != null) {
            aVar.cancel();
            this.b = null;
        }
    }

    public void d() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (cVar = this.c) != null) {
            cVar.cancel();
            this.c = null;
        }
    }

    public final List<sw4> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashSet<String> hashSet = new HashSet<>();
            return e(this.d, e(this.d, null, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, hashSet), MediaStore.Images.Media.INTERNAL_CONTENT_URI, hashSet);
        }
        return (List) invokeV.objValue;
    }

    public final List<sw4> e(Context context, List<sw4> list, Uri uri, HashSet<String> hashSet) {
        InterceptResult invokeLLLL;
        List<sw4> list2;
        int i;
        File[] listFiles;
        Matcher matcher;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, list, uri, hashSet)) == null) {
            Cursor cursor = null;
            if (context == null) {
                return null;
            }
            Pattern compile = Pattern.compile("image\\/\\w+", 2);
            if (list == null) {
                list2 = new ArrayList<>();
            } else {
                list2 = list;
            }
            try {
                try {
                    cursor = context.getContentResolver().query(uri, new String[]{"bucket_id", "bucket_display_name", "_data", "count(*)"}, "mime_type like 'image/%') GROUP BY 1,(2", null, "date_added DESC");
                    if (cursor.moveToFirst()) {
                        int columnIndex = cursor.getColumnIndex("bucket_id");
                        int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
                        int columnIndex3 = cursor.getColumnIndex("_data");
                        int columnIndex4 = cursor.getColumnIndex("count(*)");
                        do {
                            String string = cursor.getString(columnIndex);
                            String string2 = cursor.getString(columnIndex2);
                            String string3 = cursor.getString(columnIndex3);
                            cursor.getString(columnIndex4);
                            String substring = string3.substring(0, string3.lastIndexOf("/"));
                            if (hashSet != null) {
                                if (!hashSet.contains(substring)) {
                                    hashSet.add(substring);
                                }
                            }
                            File file = new File(substring);
                            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                                i = 0;
                                for (File file2 : listFiles) {
                                    String j = j(file2.getAbsolutePath());
                                    if (j != null && (matcher = compile.matcher(j)) != null && matcher.matches()) {
                                        i++;
                                    }
                                }
                            } else {
                                i = 0;
                            }
                            if (i != 0) {
                                sw4 sw4Var = new sw4();
                                sw4Var.h(string);
                                sw4Var.i(i + "");
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                File file3 = new File(string3);
                                if (file3.exists() && file3.isFile()) {
                                    imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(file3.lastModified()));
                                }
                                imageFileInfo.setFilePath(string3);
                                sw4Var.k(imageFileInfo);
                                sw4Var.l(string2);
                                if (string2 != null && string2.equals(this.a)) {
                                    list2.add(0, sw4Var);
                                } else {
                                    list2.add(sw4Var);
                                }
                            }
                        } while (cursor.moveToNext());
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                return list2;
            } finally {
                sg.a(cursor);
            }
        }
        return (List) invokeLLLL.objValue;
    }

    public final String h(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                int lastIndexOf2 = str.lastIndexOf(35);
                if (lastIndexOf2 > 0) {
                    str = str.substring(0, lastIndexOf2);
                }
                int lastIndexOf3 = str.lastIndexOf(63);
                if (lastIndexOf3 > 0) {
                    str = str.substring(0, lastIndexOf3);
                }
                int lastIndexOf4 = str.lastIndexOf(47);
                if (lastIndexOf4 >= 0) {
                    str = str.substring(lastIndexOf4 + 1);
                }
                if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) >= 0 && lastIndexOf < str.length() - 1) {
                    return str.substring(lastIndexOf + 1);
                }
                return "";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public boolean i(String str, vw4 vw4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, vw4Var)) == null) {
            if (vw4Var == null) {
                return false;
            }
            d();
            c cVar = new c(this, str, vw4Var);
            this.c = cVar;
            cVar.setPriority(3);
            this.c.execute(new Void[0]);
            return true;
        }
        return invokeLL.booleanValue;
    }
}
