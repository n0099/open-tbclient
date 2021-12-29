package com.bytedance.pangle;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.view.ContextThemeWrapper;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/* loaded from: classes2.dex */
public class e extends ContextThemeWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public File mCacheDir;
    public File mCodeCacheDir;
    public File mDataDir;
    public File mExternalCacheDir;
    public File mFilesDir;
    public File mNoBackupFilesDir;
    public File mObbDir;
    public final Object mSync;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSync = new Object();
    }

    public static File ensurePrivateDirExists(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static File makeFilename(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, str)) == null) {
            if (str.indexOf(File.separatorChar) < 0) {
                return new File(file, str);
            }
            throw new IllegalArgumentException("File " + str + " contains a path separator");
        }
        return (File) invokeLL.objValue;
    }

    private String makeSubName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            return getPluginDirName() + "_" + str;
        }
        return (String) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (getPluginDirName() == null) {
                return super.databaseList();
            }
            String[] databaseList = super.databaseList();
            int length = databaseList.length;
            boolean[] zArr = new boolean[length];
            int i2 = 0;
            for (int i3 = 0; i3 < databaseList.length; i3++) {
                if (databaseList[i3].startsWith(getPluginDirName())) {
                    zArr[i3] = true;
                    i2++;
                } else {
                    zArr[i3] = false;
                }
            }
            String[] strArr = new String[i2];
            int i4 = 0;
            for (int i5 = 0; i5 < length; i5++) {
                if (zArr[i5]) {
                    strArr[i4] = databaseList[i5];
                    i4++;
                }
            }
            return strArr;
        }
        return (String[]) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (getPluginDirName() == null) {
                return super.deleteDatabase(str);
            }
            return super.deleteDatabase(makeSubName(str));
        }
        return invokeL.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? makeFilename(getFilesDir(), str).delete() : invokeL.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (getPluginDirName() == null) {
                return super.deleteSharedPreferences(str);
            }
            return super.deleteSharedPreferences(makeSubName(str));
        }
        return invokeL.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        InterceptResult invokeV;
        File ensurePrivateDirExists;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (getPluginDirName() == null) {
                return super.getCacheDir();
            }
            synchronized (this.mSync) {
                if (this.mCacheDir == null) {
                    this.mCacheDir = new File(super.getCacheDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mCacheDir);
            }
            return ensurePrivateDirExists;
        }
        return (File) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        InterceptResult invokeV;
        File ensurePrivateDirExists;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getPluginDirName() == null) {
                return super.getCodeCacheDir();
            }
            synchronized (this.mSync) {
                if (this.mCodeCacheDir == null) {
                    this.mCodeCacheDir = new File(super.getCodeCacheDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mCodeCacheDir);
            }
            return ensurePrivateDirExists;
        }
        return (File) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        InterceptResult invokeV;
        File ensurePrivateDirExists;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (getPluginDirName() == null) {
                return super.getDataDir();
            }
            synchronized (this.mSync) {
                if (this.mDataDir == null) {
                    this.mDataDir = new File(getHostDataDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mDataDir);
            }
            return ensurePrivateDirExists;
        }
        return (File) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (getPluginDirName() == null) {
                return super.getDatabasePath(str);
            }
            return super.getDatabasePath(makeSubName(str));
        }
        return (File) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2)) == null) {
            if (i2 == 0 && getPluginDirName() != null) {
                return ensurePrivateDirExists(new File(super.getDir(str, i2), getPluginDirName()));
            }
            return super.getDir(str, i2);
        }
        return (File) invokeLI.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        InterceptResult invokeV;
        File ensurePrivateDirExists;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (getPluginDirName() == null) {
                return super.getExternalCacheDir();
            }
            synchronized (this.mSync) {
                if (this.mExternalCacheDir == null) {
                    this.mExternalCacheDir = new File(super.getExternalCacheDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mExternalCacheDir);
            }
            return ensurePrivateDirExists;
        }
        return (File) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (getPluginDirName() == null) {
                return super.getExternalCacheDirs();
            }
            File[] externalCacheDirs = super.getExternalCacheDirs();
            File[] fileArr = new File[externalCacheDirs.length];
            for (int i2 = 0; i2 < externalCacheDirs.length; i2++) {
                fileArr[i2] = ensurePrivateDirExists(new File(externalCacheDirs[i2], getPluginDirName()));
            }
            return fileArr;
        }
        return (File[]) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (getPluginDirName() == null) {
                return super.getExternalFilesDir(str);
            }
            return ensurePrivateDirExists(new File(super.getExternalFilesDir(str), getPluginDirName()));
        }
        return (File) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (getPluginDirName() == null) {
                return super.getExternalFilesDirs(str);
            }
            File[] externalFilesDirs = super.getExternalFilesDirs(str);
            File[] fileArr = new File[externalFilesDirs.length];
            for (int i2 = 0; i2 < externalFilesDirs.length; i2++) {
                fileArr[i2] = ensurePrivateDirExists(new File(externalFilesDirs[i2], getPluginDirName()));
            }
            return fileArr;
        }
        return (File[]) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (getPluginDirName() == null) {
                return super.getExternalMediaDirs();
            }
            File[] externalMediaDirs = super.getExternalMediaDirs();
            File[] fileArr = new File[externalMediaDirs.length];
            for (int i2 = 0; i2 < externalMediaDirs.length; i2++) {
                fileArr[i2] = ensurePrivateDirExists(new File(externalMediaDirs[i2], getPluginDirName()));
            }
            return fileArr;
        }
        return (File[]) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        InterceptResult invokeV;
        File ensurePrivateDirExists;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (getPluginDirName() == null) {
                return super.getFilesDir();
            }
            synchronized (this.mSync) {
                if (this.mFilesDir == null) {
                    this.mFilesDir = new File(super.getFilesDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mFilesDir);
            }
            return ensurePrivateDirExists;
        }
        return (File) invokeV.objValue;
    }

    public File getHostDataDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? super.getFilesDir().getParentFile() : (File) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        InterceptResult invokeV;
        File ensurePrivateDirExists;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (getPluginDirName() == null) {
                return super.getNoBackupFilesDir();
            }
            synchronized (this.mSync) {
                if (this.mNoBackupFilesDir == null) {
                    this.mNoBackupFilesDir = new File(super.getNoBackupFilesDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mNoBackupFilesDir);
            }
            return ensurePrivateDirExists;
        }
        return (File) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        InterceptResult invokeV;
        File ensurePrivateDirExists;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (getPluginDirName() == null) {
                return super.getObbDir();
            }
            synchronized (this.mSync) {
                if (this.mObbDir == null) {
                    this.mObbDir = new File(super.getObbDir(), getPluginDirName());
                }
                ensurePrivateDirExists = ensurePrivateDirExists(this.mObbDir);
            }
            return ensurePrivateDirExists;
        }
        return (File) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (getPluginDirName() == null) {
                return super.getObbDirs();
            }
            File[] obbDirs = super.getObbDirs();
            File[] fileArr = new File[obbDirs.length];
            for (int i2 = 0; i2 < obbDirs.length; i2++) {
                fileArr[i2] = ensurePrivateDirExists(new File(obbDirs[i2], getPluginDirName()));
            }
            return fileArr;
        }
        return (File[]) invokeV.objValue;
    }

    public String getPluginDirName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return ZeusConstants.BASE_LIB_NAME + "_" + getPluginPkg();
        }
        return (String) invokeV.objValue;
    }

    public String getPluginPkg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, str, i2)) == null) {
            if (i2 == 0 && getPluginDirName() != null) {
                return super.getSharedPreferences(makeSubName(str), i2);
            }
            return super.getSharedPreferences(str, i2);
        }
        return (SharedPreferences) invokeLI.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, context, str)) == null) {
            if (getPluginDirName() == null) {
                return super.moveDatabaseFrom(context, str);
            }
            throw new UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
        }
        return invokeLL.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            if (getPluginDirName() == null) {
                return super.openFileInput(str);
            }
            return new FileInputStream(makeFilename(getFilesDir(), str));
        }
        return (FileInputStream) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, str, i2)) == null) {
            if (i2 == 0 && getPluginDirName() != null) {
                return new FileOutputStream(makeFilename(getFilesDir(), str), false);
            }
            return super.openFileOutput(str, i2);
        }
        return (FileOutputStream) invokeLI.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, SQLiteDatabase.CursorFactory cursorFactory) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048601, this, str, i2, cursorFactory)) == null) {
            if (i2 == 0 && getPluginDirName() != null) {
                return super.openOrCreateDatabase(makeSubName(str), i2, cursorFactory);
            }
            return super.openOrCreateDatabase(str, i2, cursorFactory);
        }
        return (SQLiteDatabase) invokeLIL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSync = new Object();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048602, this, str, i2, cursorFactory, databaseErrorHandler)) == null) {
            if (i2 == 0 && getPluginDirName() != null) {
                return super.openOrCreateDatabase(makeSubName(str), i2, cursorFactory, databaseErrorHandler);
            }
            return super.openOrCreateDatabase(str, i2, cursorFactory, databaseErrorHandler);
        }
        return (SQLiteDatabase) invokeLILL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 23)
    public e(Context context, Resources.Theme theme) {
        super(context, theme);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, theme};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (Resources.Theme) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mSync = new Object();
    }
}
