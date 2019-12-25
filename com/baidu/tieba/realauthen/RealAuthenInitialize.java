package com.baidu.tieba.realauthen;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.FaceRecognitionActivityConfig;
import com.baidu.tieba.realauthen.activity.FaceRecognitionActivity;
/* loaded from: classes2.dex */
public class RealAuthenInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(FaceRecognitionActivityConfig.class, FaceRecognitionActivity.class);
    }
}
