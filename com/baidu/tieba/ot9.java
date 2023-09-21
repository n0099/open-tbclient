package com.baidu.tieba;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes7.dex */
public interface ot9 {
    PbFragment S1();

    AbsVideoPbFragment b0();

    PbModel.h c1();

    PbModel f0();

    void finish();

    TbPageContext getPageContext();

    AbsPbActivity m0();

    void registerListener(MessageListener<?> messageListener);
}
