package com.baidu.tieba;

import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface tk0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "downloadCreator");

    IAdDownloader a();
}
