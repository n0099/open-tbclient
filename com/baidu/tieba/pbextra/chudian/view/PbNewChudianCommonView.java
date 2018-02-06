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
    private BdBaseActivity<?> gfe;
    private TextView gff;
    private TextView gfg;
    private ImageView gfh;
    private TextView gfi;
    private TextView gfj;
    private TextView gfk;
    private h gfl;
    private a.InterfaceC0203a gfm;
    private Context mContext;
    private View mRootView;

    public PbNewChudianCommonView(Context context) {
        super(context);
        this.mContext = null;
        this.gfe = null;
        this.mRootView = null;
        this.gff = null;
        this.gfg = null;
        this.gfh = null;
        this.gfi = null;
        this.gfj = null;
        this.gfk = null;
        this.gfl = null;
        this.gfm = null;
        this.mContext = context;
        init();
    }

    public PbNewChudianCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.gfe = null;
        this.mRootView = null;
        this.gff = null;
        this.gfg = null;
        this.gfh = null;
        this.gfi = null;
        this.gfj = null;
        this.gfk = null;
        this.gfl = null;
        this.gfm = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        if (this.mContext != null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.pb_newchudian_common, (ViewGroup) this, true);
            this.gff = (TextView) this.mRootView.findViewById(d.g.service_first);
            this.gff.setOnClickListener(this);
            this.gfg = (TextView) this.mRootView.findViewById(d.g.service_second);
            this.gfg.setOnClickListener(this);
            this.gfi = (TextView) this.mRootView.findViewById(d.g.land_mark_text);
            this.gfh = (ImageView) this.mRootView.findViewById(d.g.land_mark_icon);
            this.gfj = (TextView) this.mRootView.findViewById(d.g.check_detail_up);
            this.gfj.setOnClickListener(this);
            this.gfk = (TextView) this.mRootView.findViewById(d.g.check_detail_down);
            this.gfk.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gfl != null) {
            if (view == this.gff) {
                if (this.gfl.bwz() != null) {
                    a(this.gfl.bwz().get(0));
                }
            } else if (view == this.gfg) {
                if (this.gfl.bwz() != null) {
                    a(this.gfl.bwz().get(1));
                }
            } else if (view == this.gfj || view == this.gfk) {
                i bwB = this.gfl.bwB();
                if (!am.isEmpty(bwB.getUrl())) {
                    b.R(this.mContext, bwB.getUrl());
                    if (this.gfm != null) {
                        this.gfm.d(bwB.getUrl(), "BUTTON", "CLICK", null, null);
                    }
                }
            }
        }
    }

    private void a(g gVar) {
        if (gVar != null) {
            final String trim = gVar.getUrl().trim();
            if (this.gfm != null) {
                this.gfm.d(trim, "BTN_PHONE", "CLICK", null, null);
            }
            if (!am.isEmpty(trim)) {
                int type = gVar.getType();
                if (type == 1) {
                    b.R(this.mContext, trim);
                } else if (type == 2) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gfe.getActivity());
                    aVar.dk(trim);
                    aVar.a(this.gfe.getResources().getString(d.j.phone_call), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            UtilHelper.callPhone(PbNewChudianCommonView.this.mContext, trim);
                            if (PbNewChudianCommonView.this.gfm != null) {
                                PbNewChudianCommonView.this.gfm.d(trim, "BTN_CALL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.b(this.gfe.getResources().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.pbextra.chudian.view.PbNewChudianCommonView.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (PbNewChudianCommonView.this.gfm != null) {
                                PbNewChudianCommonView.this.gfm.d(trim, "BTN_CANCEL", "CLICK_FEEDBACK", null, null);
                            }
                        }
                    });
                    aVar.ba(false);
                    aVar.b(this.gfe.getPageContext());
                    aVar.AU();
                }
            }
        }
    }
}
