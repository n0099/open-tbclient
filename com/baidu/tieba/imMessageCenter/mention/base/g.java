package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g {
    private TbPageContext dIF;
    private ImageView eLj;
    private TextView iRR;
    private TBSpecificationBtn iRS;
    private a iRT;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.base.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == g.this.iRS.getId()) {
                com.baidu.tbadk.coreExtra.c.a.g(g.this.dIF);
                TiebaStatic.log(new an("c13705").ag("obj_type", 1));
            } else if (view.getId() == g.this.eLj.getId()) {
                com.baidu.tbadk.core.sharedPref.b.aTX().putLong("key_im_open_notification_close_time", System.currentTimeMillis());
                if (g.this.iRT != null) {
                    g.this.iRT.onClose();
                }
                TiebaStatic.log(new an("c13705").ag("obj_type", 2));
            }
        }
    };
    private View mView;

    /* loaded from: classes9.dex */
    public interface a {
        void onClose();
    }

    public g(TbPageContext tbPageContext) {
        this.dIF = tbPageContext;
        this.mView = LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.open_notification_view, (ViewGroup) null);
        this.eLj = (ImageView) this.mView.findViewById(R.id.img_close);
        this.eLj.setOnClickListener(this.mOnClickListener);
        this.iRR = (TextView) this.mView.findViewById(R.id.open_desc);
        this.iRS = (TBSpecificationBtn) this.mView.findViewById(R.id.btn_open);
        this.iRS.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.iRS.setText(tbPageContext.getString(R.string.go_to_open));
        this.iRS.setOnClickListener(this.mOnClickListener);
        TiebaStatic.log("c13704");
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mView;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mView, R.color.cp_bg_line_g);
        SvgManager.aUW().a(this.eLj, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.iRR, (int) R.color.cp_cont_j);
    }

    public void a(a aVar) {
        this.iRT = aVar;
    }
}
