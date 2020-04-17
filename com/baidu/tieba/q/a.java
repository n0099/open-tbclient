package com.baidu.tieba.q;

import com.baidu.searchbox.cloudcontrol.processor.DataProcessors;
import com.baidu.searchbox.cloudcontrol.runtime.ICloudControlRegister;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
/* loaded from: classes.dex */
public class a implements ICloudControlRegister {
    @Override // com.baidu.searchbox.cloudcontrol.runtime.ICloudControlRegister
    public void registerAllProcessors(DataProcessors dataProcessors) {
        dataProcessors.addProcessor("ubc", new UBCCloudControlProcessor());
    }
}
