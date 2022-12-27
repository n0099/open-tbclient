package com.baidu.tieba;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes6.dex */
public interface t78 {
    PbModel.h E0();

    AbsVideoPbFragment J();

    PbModel M();

    AbsPbActivity R();

    void finish();

    TbPageContext getPageContext();

    PbFragment r1();

    void registerListener(MessageListener<?> messageListener);
}
