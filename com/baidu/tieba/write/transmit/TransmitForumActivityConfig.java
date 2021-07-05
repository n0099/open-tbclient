package com.baidu.tieba.write.transmit;

import android.content.Context;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class TransmitForumActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_FORUM_LIST_SELECTED = "KEY_FORUM_LIST_SELECTED";
    public static final String KEY_RECOMMEND_FORUM_LIST = "KEY_RECOMMEND_FORUM_LIST";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransmitForumActivityConfig(Context context, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setRecommendForumList(ArrayList<TransmitForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) || getIntent() == null) {
            return;
        }
        getIntent().putParcelableArrayListExtra(KEY_RECOMMEND_FORUM_LIST, arrayList);
    }
}
