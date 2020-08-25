package com.baidu.tieba.pb.videopb;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes16.dex */
public interface b {
    PbModel cWD();

    PbModel.a cXG();

    PbFragment cYg();

    VideoPbFragment cYh();

    PbActivity cYi();

    void finish();

    TbPageContext getPageContext();

    void registerListener(MessageListener<?> messageListener);
}
