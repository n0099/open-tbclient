package com.baidu.tieba;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes5.dex */
public interface o48 {
    AbsVideoPbFragment B();

    PbModel.h B0();

    PbModel K();

    AbsPbActivity P();

    void finish();

    TbPageContext getPageContext();

    PbFragment k1();

    void registerListener(MessageListener<?> messageListener);
}
