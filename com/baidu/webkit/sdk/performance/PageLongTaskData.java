package com.baidu.webkit.sdk.performance;

import android.util.Pair;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class PageLongTaskData {
    public long mDomComplete;
    public long mEnd;
    public long mFCP;
    public long mFMP;
    public long mFSP;
    public ArrayList<Pair<Long, Integer>> mLongTaskList = new ArrayList<>();
    public int mLongTaskSize;
    public long mNavigationStart;
    public long mSameDomNavigation;
    public long mSwapIn;
}
