package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.AsyncChatTask;
import com.baidu.android.imsdk.upload.AsyncUploadTask;
import com.baidu.android.imsdk.upload.IUploadTransferListener;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.cipher.Base64Util;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
/* loaded from: classes6.dex */
public class ut7 implements IGenBosObjectUrlListener, IUploadTransferListener, BIMValueCallBack<String>, ISendMessageListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "ut7";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public tt7 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948222609, "Lcom/baidu/tieba/ut7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948222609, "Lcom/baidu/tieba/ut7;");
        }
    }

    @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
    public void onProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
    public void onSendMessageResult(int i, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, chatMsg) == null) {
        }
    }

    public ut7(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.android.imsdk.group.BIMValueCallBack
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResult(int i, String str, String str2) {
        FileOutputStream fileOutputStream;
        Throwable th;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
            if (i == 0 && !TextUtils.isEmpty(str2)) {
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        byte[] decode = Base64Util.decode(str2);
                        File file = new File(this.b);
                        if (file.exists()) {
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                try {
                                    fileOutputStream.write(decode);
                                    fileOutputStream.flush();
                                    fileOutputStream2 = fileOutputStream;
                                } catch (Exception e2) {
                                    e = e2;
                                    if (this.c != null) {
                                        this.c.isFailed();
                                    }
                                    LogUtils.e(d, e.getMessage());
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    BIMManager.genBosObjectUrl(this.a, this.b, "mp3", "mp3", 12, 0, 0, this);
                                    return;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e3) {
                                        LogUtils.e(d, e3.getMessage());
                                    }
                                }
                                throw th;
                            }
                        } else if (this.c != null) {
                            this.c.isFailed();
                        }
                    } catch (Exception e4) {
                        LogUtils.e(d, e4.getMessage());
                    }
                } catch (Exception e5) {
                    fileOutputStream = null;
                    e = e5;
                } catch (Throwable th3) {
                    fileOutputStream = null;
                    th = th3;
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                BIMManager.genBosObjectUrl(this.a, this.b, "mp3", "mp3", 12, 0, 0, this);
                return;
            }
            tt7 tt7Var = this.c;
            if (tt7Var != null) {
                tt7Var.isFailed();
            }
        }
    }

    public void b(@NonNull tt7 tt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tt7Var) == null) {
            this.c = tt7Var;
        }
    }

    @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
    public void onFailed(int i, int i2, String str) {
        tt7 tt7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, str) == null) && (tt7Var = this.c) != null) {
            tt7Var.isFailed();
        }
    }

    @Override // com.baidu.android.imsdk.upload.IUploadTransferListener
    public void onFinished(int i, String str) {
        tt7 tt7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) && (tt7Var = this.c) != null) {
            tt7Var.a(str);
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener
    public void onGenBosObjectUrlListener(int i, String str, String str2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), str, str2, str3, map}) == null) {
            if (i == 0) {
                new AsyncUploadTask(this.a, 2, map.get(AsyncChatTask.PUT_URL), map.get(AsyncChatTask.GET_URL), this.b, "mp3", str2, str3, this).execute(new Void[0]);
                return;
            }
            tt7 tt7Var = this.c;
            if (tt7Var != null) {
                tt7Var.isFailed();
            }
        }
    }
}
