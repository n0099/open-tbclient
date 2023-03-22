package com.baidu.tieba;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes6.dex */
public interface wp8 {
    AbsVideoPbFragment D();

    PbModel.h F0();

    PbModel L();

    AbsPbActivity M();

    void finish();

    TbPageContext getPageContext();

    void registerListener(MessageListener<?> messageListener);

    PbFragment w1();
}
