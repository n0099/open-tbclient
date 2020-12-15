package com.baidu.tieba.pb.videopb;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes22.dex */
public interface b {
    PbModel dol();

    PbFragment dpP();

    VideoPbFragment dpQ();

    PbActivity dpR();

    PbModel.a dpp();

    void finish();

    TbPageContext getPageContext();

    void registerListener(MessageListener<?> messageListener);
}
