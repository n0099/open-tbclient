package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ak extends q.a {
    private CustomMessageListener UN;
    public TextLineView fnc;
    public TextLineView fnd;
    public TextView fne;
    public TextView fnf;
    public View fng;
    public View fnh;
    public View fni;
    public TextLineView fnj;
    public View fnk;
    private com.baidu.tieba.pb.pb.godreply.usertips.a fnl;
    private List<TextLineView> fnm;
    private int fnn;
    private View.OnClickListener fno;
    private com.baidu.tieba.pb.data.h fnp;
    private BdUniqueId fnq;
    private BdUniqueId fnr;
    private View.OnClickListener fns;
    private View.OnClickListener fnt;
    private CustomMessageListener fnu;
    private View mRootView;
    public int mSkinType;

    public ak(TbPageContext tbPageContext, View view2) {
        super(view2);
        this.mSkinType = 3;
        this.fnl = new com.baidu.tieba.pb.pb.godreply.usertips.a();
        this.fnn = 0;
        this.fns = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (ak.this.fno != null) {
                    ak.this.fno.onClick(view3);
                }
                if (com.baidu.adp.lib.util.j.gP()) {
                    if (view3 == null || !(view3.getTag() instanceof Boolean) || ((Boolean) view3.getTag()).booleanValue()) {
                        for (TextLineView textLineView : ak.this.fnm) {
                            if (textLineView != null) {
                                if (textLineView != view3) {
                                    textLineView.setSelected(false);
                                } else {
                                    textLineView.setSelected(true);
                                }
                            }
                        }
                    }
                }
            }
        };
        this.fnt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (ak.this.fno != null) {
                    ak.this.fno.onClick(view3);
                }
                if (com.baidu.adp.lib.util.j.gP() && view3 != null && (view3.getTag() instanceof Boolean)) {
                    ak.this.jZ(!((Boolean) view3.getTag()).booleanValue());
                }
            }
        };
        this.UN = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.ak.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fnp != null && ak.this.fnp.mType == com.baidu.tieba.pb.data.h.fcB && customResponsedMessage != null && getTag() == ak.this.fnq && (customResponsedMessage.getData() instanceof as.a)) {
                    ((as.a) customResponsedMessage.getData()).fqQ = ak.this;
                }
            }
        };
        this.fnu = new CustomMessageListener(2004013) { // from class: com.baidu.tieba.pb.pb.main.ak.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ak.this.fnp != null && ak.this.fnp.mType == com.baidu.tieba.pb.data.h.fcC && customResponsedMessage != null && getTag() == ak.this.fnr && (customResponsedMessage.getData() instanceof as.a) && ak.this.mRootView != null && ak.this.fnl.aWH() && ak.this.fnf != null && ak.this.fnf.getVisibility() == 0) {
                    if (ak.this.mRootView == null || ak.this.mRootView.getParent() == null) {
                        ak.this.fnl.hideTip();
                        return;
                    }
                    if (!ak.this.fnl.aWH() && !com.baidu.tieba.pb.pb.godreply.usertips.b.bP(ak.this.mRootView.getContext())) {
                        ak.this.fnl.showTip(ak.this.fnf);
                    }
                    if (ak.this.fnl.aWH()) {
                        ak.this.fnl.aU(ak.this.fnf);
                    }
                }
            }
        };
        if (view2 != null) {
            this.mRootView = view2;
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                }
            });
            this.fnc = (TextLineView) view2.findViewById(d.g.reply_title);
            this.fnc.setOnClickListener(this.fns);
            this.fni = view2.findViewById(d.g.reply_god_title_group);
            this.fnj = (TextLineView) view2.findViewById(d.g.reply_god_title);
            this.fnj.setSelected(false);
            this.fnk = view2.findViewById(d.g.reply_all_title);
            this.fnd = (TextLineView) view2.findViewById(d.g.floor_owner_reply);
            this.fnd.setOnClickListener(this.fns);
            this.fne = (TextView) view2.findViewById(d.g.pb_sort);
            this.fne.setOnClickListener(this.fnt);
            this.fnf = (TextView) view2.findViewById(d.g.pb_god_reply_entrance_text);
            this.fnc.setSelected(true);
            this.fnd.setSelected(false);
            this.fnm = new ArrayList();
            this.fnm.add(this.fnc);
            this.fnm.add(this.fnd);
            this.fng = view2.findViewById(d.g.divider_with_reply_title);
            this.fnh = view2.findViewById(d.g.divider_bottom);
            jZ(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void jZ(boolean z) {
        this.fnn = z ? 0 : 1;
        this.fne.setVisibility(0);
        if (this.fnn == 1) {
            this.fne.setText(d.k.default_sort);
        } else if (this.fnn == 0) {
            this.fne.setText(d.k.view_reverse);
        }
    }

    public void ka(boolean z) {
        if (z) {
            this.fnd.setSelected(true);
            this.fnc.setSelected(false);
            return;
        }
        this.fnd.setSelected(false);
        this.fnc.setSelected(true);
    }

    public void a(com.baidu.tieba.pb.data.h hVar) {
        this.fnp = hVar;
        if (hVar != null) {
            if (hVar.mType == com.baidu.tieba.pb.data.h.fcC) {
                final Context context = this.fni.getContext();
                if (TextUtils.isEmpty(hVar.fcE)) {
                    this.fnk.setVisibility(0);
                    this.fni.setVisibility(8);
                    this.fnc.setVisibility(0);
                    this.fnc.setSelected(false);
                    this.fnc.setClickable(false);
                    this.fnc.setText(TbadkCoreApplication.getInst().getString(d.k.god_reply));
                } else {
                    this.fnk.setVisibility(8);
                    this.fnc.setVisibility(8);
                    this.fni.setVisibility(0);
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            com.baidu.tieba.pb.pb.godreply.usertips.b.u(context, true);
                            ak.this.fnl.hideTip();
                            if (ak.this.fno != null) {
                                ak.this.fno.onClick(ak.this.fni);
                            }
                        }
                    };
                    this.fni.setOnClickListener(onClickListener);
                    if (!com.baidu.tieba.pb.pb.godreply.usertips.b.bP(context) && this.fnf != null && this.fnf.getVisibility() == 0 && !this.fnl.aWH()) {
                        this.fnl.G(onClickListener);
                        this.fnl.showTip(this.fnf);
                    }
                }
                this.fne.setVisibility(8);
                this.fnd.setVisibility(8);
                this.fnh.setVisibility(8);
            } else if (hVar.mType == com.baidu.tieba.pb.data.h.fcB) {
                this.fni.setVisibility(8);
                this.fnk.setVisibility(0);
                this.fnc.setClickable(true);
                this.fnc.setText(TbadkCoreApplication.getInst().getString(d.k.all_reply));
                this.fne.setVisibility(0);
                this.fnd.setVisibility(0);
                ka(hVar.fcF);
                jZ(hVar.isNew);
                this.fnh.setVisibility(0);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ak.j(getView(), d.C0126d.cp_bg_line_d);
            this.fnc.onChangeSkinType(i);
            this.fnd.onChangeSkinType(i);
            com.baidu.tbadk.core.util.ak.h(this.fnj, d.C0126d.cp_cont_b);
            if (this.fnp != null && this.fnp.mType == com.baidu.tieba.pb.data.h.fcC) {
                com.baidu.tbadk.core.util.ak.c(this.fnc, d.C0126d.cp_cont_j, 1);
            }
            com.baidu.tbadk.core.util.ak.h(this.fnf, d.C0126d.cp_cont_j);
            this.fnf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_gob_reply_jump), (Drawable) null);
            com.baidu.tbadk.core.util.ak.h(this.fne, d.C0126d.cp_cont_j);
            com.baidu.tbadk.core.util.ak.j(this.fng, d.C0126d.cp_bg_line_e);
            com.baidu.tbadk.core.util.ak.j(this.fnh, d.C0126d.cp_bg_line_c);
            this.fne.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ak.getDrawable(d.f.icon_pb_sort), (Drawable) null);
            this.fnl.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    public void h(BdUniqueId bdUniqueId) {
        this.fnq = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.UN.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.UN);
    }

    public void n(BdUniqueId bdUniqueId) {
        this.fnr = bdUniqueId;
        MessageManager.getInstance().unRegisterListener(bdUniqueId);
        this.fnu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fnu);
    }

    public void H(View.OnClickListener onClickListener) {
        this.fno = onClickListener;
    }
}
