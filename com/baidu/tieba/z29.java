package com.baidu.tieba;

import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
/* loaded from: classes7.dex */
public interface z29 {
    PbModel.h K0();

    AbsVideoPbFragment N();

    PbModel Q();

    AbsPbActivity R();

    void finish();

    TbPageContext getPageContext();

    void registerListener(MessageListener<?> messageListener);

    PbFragment x1();
}
