package com.baidu.tieba.write.transmit;

import android.content.Context;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class TransmitForumActivityConfig extends IntentConfig {
    public static final String KEY_FORUM_LIST_SELECTED = "KEY_FORUM_LIST_SELECTED";
    public static final String KEY_RECOMMEND_FORUM_LIST = "KEY_RECOMMEND_FORUM_LIST";

    public TransmitForumActivityConfig(Context context, int i2) {
        super(context);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setRecommendForumList(ArrayList<TransmitForumData> arrayList) {
        if (getIntent() != null) {
            getIntent().putParcelableArrayListExtra(KEY_RECOMMEND_FORUM_LIST, arrayList);
        }
    }
}
