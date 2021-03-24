package com.baidu.wallet.paysdk.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class FeedbackInfo implements NoProguard, Serializable {
    public static final long serialVersionUID = 1;
    public String entry_desc;
    public String entry_uri;
    public FeedbackTag[] negative;
    public FeedbackTag[] positive;
    public String question_desc;
    public String[] score_desc;

    /* loaded from: classes5.dex */
    public static class FeedbackTag implements NoProguard, Serializable {
        public static final long serialVersionUID = 1;
        public String desc;
        public String key;
    }

    public boolean isEntryValid() {
        return (TextUtils.isEmpty(this.entry_desc) || TextUtils.isEmpty(this.entry_uri)) ? false : true;
    }
}
