package com.baidu.tieba.publisher.service;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.account.BoxAccountManager;
/* loaded from: classes2.dex */
public class b extends com.baidu.pyramid.runtime.service.a<BoxAccountManager> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.pyramid.runtime.service.a
    /* renamed from: cBc */
    public BoxAccountManager createService() throws ServiceNotFoundException {
        return new a();
    }
}
