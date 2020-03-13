package com.baidu.tieba.publisher.service;

import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.ugc.service.AtService;
/* loaded from: classes2.dex */
public class c extends com.baidu.pyramid.runtime.service.a<AtService> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.pyramid.runtime.service.a
    /* renamed from: cBd */
    public AtService createService() throws ServiceNotFoundException {
        return new com.baidu.tieba.publisher.a.a();
    }
}
