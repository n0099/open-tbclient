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
    private ImageView eKY;
    private TextView iRe;
    private TBSpecificationBtn iRf;
    private a iRg;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.base.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == g.this.iRf.getId()) {
                com.baidu.tbadk.coreExtra.c.a.g(g.this.dIF);
                TiebaStatic.log(new an("c13705").ag("obj_type", 1));
            } else if (view.getId() == g.this.eKY.getId()) {
                com.baidu.tbadk.core.sharedPref.b.aTX().putLong("key_im_open_notification_close_time", System.currentTimeMillis());
                if (g.this.iRg != null) {
                    g.this.iRg.onClose();
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
        this.eKY = (ImageView) this.mView.findViewById(R.id.img_close);
        this.eKY.setOnClickListener(this.mOnClickListener);
        this.iRe = (TextView) this.mView.findViewById(R.id.open_desc);
        this.iRf = (TBSpecificationBtn) this.mView.findViewById(R.id.btn_open);
        this.iRf.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.iRf.setText(tbPageContext.getString(R.string.go_to_open));
        this.iRf.setOnClickListener(this.mOnClickListener);
        TiebaStatic.log("c13704");
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mView;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mView, R.color.cp_bg_line_g);
        SvgManager.aUV().a(this.eKY, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.iRe, (int) R.color.cp_cont_j);
    }

    public void a(a aVar) {
        this.iRg = aVar;
    }
}
