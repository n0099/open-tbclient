package com.baidu.tieba;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes8.dex */
public interface w49 {
    PbModel.h L0();

    AbsVideoPbFragment M();

    PbModel P();

    AbsPbActivity R();

    void finish();

    TbPageContext getPageContext();

    void registerListener(MessageListener<?> messageListener);

    PbFragment y1();
}
