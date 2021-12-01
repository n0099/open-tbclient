package com.baidu.tieba.usermute;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class UserMuteAddAndDelCustomMessage extends CustomMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PB = 1;
    public static final int PERSON_INFO = 0;
    public static final int SETTING = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public int from;
    public boolean isMute;
    public BdUniqueId mId;
    public String msg;
    public String muteUserId;
    public String postId;
    public String threadId;
    public String userName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserMuteAddAndDelCustomMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.from = -1;
    }

    public void setData(boolean z, String str, String str2, String str3, String str4, int i2, String str5, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2, str3, str4, Integer.valueOf(i2), str5, bdUniqueId}) == null) {
            this.isMute = z;
            this.muteUserId = str;
            this.userName = str2;
            this.threadId = str3;
            this.postId = str4;
            this.from = i2;
            this.msg = str5;
            this.mId = bdUniqueId;
        }
    }
}
