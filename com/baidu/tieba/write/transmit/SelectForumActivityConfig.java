package com.baidu.tieba.write.transmit;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SelectForumActivityConfig extends IntentConfig {
    public static final String KEY_INPUT_FORUM_LIST = "KEY_INTPUT_FORUM_LIST";
    public static final String KEY_OUTPUT_FORUM_LIST = "KEY_OUTPUT_FORUM_LIST";

    public SelectForumActivityConfig(Context context, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setForumList(ArrayList<TransmitForumData> arrayList) {
        if (getIntent() != null) {
            getIntent().putParcelableArrayListExtra(KEY_INPUT_FORUM_LIST, arrayList);
        }
    }
}
