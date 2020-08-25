package com.baidu.webkit.sdk.performance;

import android.util.Pair;
import java.util.ArrayList;
/* loaded from: classes19.dex */
public class PageLongTaskData {
    public long mDomComplete;
    public long mEnd;
    public long mFCP;
    public long mFMP;
    public long mFSP;
    public int mLongTaskSize;
    public long mNavigationStart;
    public long mSameDomNavigation;
    public long mSwapIn;
    public ArrayList<Pair<Long, Integer>> mLongTaskList = new ArrayList<>();
    public ArrayList<Pair<Long, Integer>> mIframeLongTaskList = new ArrayList<>();
}
