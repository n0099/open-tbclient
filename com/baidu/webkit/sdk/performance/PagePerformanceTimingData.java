package com.baidu.webkit.sdk.performance;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class PagePerformanceTimingData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mBrandAdCardPaint;
    public long mBrandAdLastImagePaint;
    public long mConnectEnd;
    public long mConnectStart;
    public int mDocumentLoadState;
    public long mDomComplete;
    public long mDomContentLoadedEventEnd;
    public long mDomContentLoadedEventStart;
    public long mDomInteractive;
    public long mDomLoading;
    public long mDomainLookupEnd;
    public long mDomainLookupStart;
    public long mFetchStart;
    public long mFirstImagePaint;
    public long mFirstLayout;
    public long mFirstPaint;
    public long mFirstScreenDraw;
    public int mFirstScreenElementCnt;
    public long mFirstScreenLayout;
    public long mFirstScreenPaint;
    public int mFirstScreenPaintContentHeight;
    public long mFspPresentationTime;
    public long mFspSwapTime;
    public long mLoadEventEnd;
    public long mLoadEventStart;
    public long mLoadUrlFinish;
    public long mLoadUrlStart;
    public long mNavigationStart;
    public long mParseBlockedOnScriptLoadDuration;
    public long mProxyEnd;
    public long mProxyStart;
    public int mRedirectCount;
    public long mRedirectEnd;
    public long mRedirectStart;
    public long mRequestStart;
    public long mResponseEnd;
    public long mResponseStart;
    public long mSslStart;
    public long mTagParseredClassAttributeWithResults;

    public PagePerformanceTimingData() {
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
