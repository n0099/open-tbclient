package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.tbadk.browser.b;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.tbadkCore.data.g;
import com.baidu.tieba.tbadkCore.data.h;
import com.baidu.tieba.tbadkCore.data.i;
/* loaded from: classes3.dex */
public class PbNewChudianCommonView extends RelativeLayout implements View.OnClickListener {
    private BdBaseActivity<?> gfj;
    private TextView gfk;
    private TextView gfl;
    private ImageView gfm;
    private TextView gfn;
    private TextView gfo;
    private TextView gfp;
    private h gfq;
    private a.InterfaceC0204a gfr;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.gfj = null;
        this.mRootView = null;
        this.gfk = null;
        this.gfl = null;
        this.gfm = null;
        this.gfn = null;
        this.gfo = null;
        this.gfp = null;
        this.gfq = null;
        this.gfr = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.gfj = null;
        this.mRootView = null;
        this.gfk = null;
        this.gfl = null;
        this.gfm = null;
        this.gfn = null;
        this.gfo = null;
        this.gfp = null;
        this.gfq = null;
        this.gfr = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.pb_newchudian_common, (ViewGroup) this, true);
            this.gfk = (TextView) this.mRootView.findViewById(d.g.service_first);
            this.gfk.setOnClickListener(this);
            this.gfl = (TextView) this.mRootView.findViewById(d.g.service_second);
            this.gfl.setOnClickListener(this);
            this.gfn = (TextView) this.mRootView.findViewById(d.g.land_mark_text);
            this.gfm = (ImageView) this.mRootView.findViewById(d.g.land_mark_icon);
            this.gfo = (TextView) this.mRootView.findViewById(d.g.check_detail_up);
            this.gfo.setOnClickListener(this);
            this.gfp = (TextView) this.mRootView.findViewById(d.g.check_detail_down);
            this.gfp.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gfq != null) {
            if (view == this.gfk) {
                if (this.gfq.bwD() != null) {
                    a(this.gfq.bwD().get(0));
                }
            } else if (view == this.gfl) {
                if (this.gfq.bwD() != null) {
                    a(this.gfq.bwD().get(1));
                }
            } else if (view == this.gfo || view == this.gfp) {
                i bwF = this.gfq.bwF();
                if (!am.isEmpty(bwF.getUrl())) {
                    b.R(this.mContext, bwF.getUrl());
                    if (this.gfr != null) {
                        this.gfr.d(bwF.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            final String trim = gVar.getUrl().trim();
            if (this.gfr != null) {
                this.gfr.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!am.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    b.R(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gfj.getActivity());
                    aVar.dk(trim);
                    aVar.a(this.gfj.getResources().getString(d.j.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.gfr != null) {
                                PbNewChudianCommonView.this.gfr.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.gfj.getResources().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.gfr != null) {
                                PbNewChudianCommonView.this.gfr.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.ba(false);
                    aVar.b(this.gfj.getPageContext());
                    aVar.AV();
                }
            }
        }
    }
}
