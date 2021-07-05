package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class FeedbackInfo implements NoProguard, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String entry_desc;
    public String entry_uri;
    public FeedbackTag[] negative;
    public FeedbackTag[] positive;
    public String question_desc;
    public String[] score_desc;

    /* loaded from: classes6.dex */
    public static class FeedbackTag implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String desc;
        public String key;

        public FeedbackTag() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public FeedbackInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean isEntryValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.entry_desc) || TextUtils.isEmpty(this.entry_uri)) ? false : true : invokeV.booleanValue;
    }
}
