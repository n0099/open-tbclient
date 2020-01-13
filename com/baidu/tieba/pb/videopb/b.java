package com.baidu.tieba.pb.videopb;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
/* loaded from: classes7.dex */
public interface b {
    PbModel ckc();

    PbFragment clK();

    VideoPbFragment clL();

    PbActivity clM();

    PbModel.a cll();

    void finish();

    TbPageContext getPageContext();

    void registerListener(MessageListener<?> messageListener);
}
