package com.baidu.tieba.setting.officialAccountPush;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class OfficialAccountPushActivityConfig extends IntentConfig {
    public static final String OFFICIAL_LIST = "official_list";

    public OfficialAccountPushActivityConfig(Context context, ArrayList<OfficialAccountPushInfo> arrayList) {
        super(context);
        getIntent().putParcelableArrayListExtra(OFFICIAL_LIST, arrayList);
    }
}
