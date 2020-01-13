package com.baidu.tieba.person.data;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class PersonImageActivityConfig extends IntentConfig {
    public PersonImageActivityConfig(Context context, String str) {
        super(context);
        getIntent().putExtra("curImgUrl", str);
    }

    public PersonImageActivityConfig(Context context, String str, HashMap<String, ImageUrlData> hashMap) {
        super(context);
        getIntent().putExtra("curImgUrl", str);
        getIntent().putExtra("assistUrls", hashMap);
    }
}
