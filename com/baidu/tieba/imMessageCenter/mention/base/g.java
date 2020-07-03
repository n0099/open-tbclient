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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class g {
    private TbPageContext dPv;
    private ImageView eVv;
    private TextView jjd;
    private TBSpecificationBtn jje;
    private a jjf;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.base.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == g.this.jje.getId()) {
                com.baidu.tbadk.coreExtra.c.a.j(g.this.dPv);
                TiebaStatic.log(new ao("c13705").ag("obj_type", 1));
            } else if (view.getId() == g.this.eVv.getId()) {
                com.baidu.tbadk.core.sharedPref.b.aVP().putLong("key_im_open_notification_close_time", System.currentTimeMillis());
                if (g.this.jjf != null) {
                    g.this.jjf.onClose();
                }
                TiebaStatic.log(new ao("c13705").ag("obj_type", 2));
            }
        }
    };
    private View mView;

    /* loaded from: classes9.dex */
    public interface a {
        void onClose();
    }

    public g(TbPageContext tbPageContext) {
        this.dPv = tbPageContext;
        this.mView = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.open_notification_view, (ViewGroup) null);
        this.eVv = (ImageView) this.mView.findViewById(R.id.img_close);
        this.eVv.setOnClickListener(this.mOnClickListener);
        this.jjd = (TextView) this.mView.findViewById(R.id.open_desc);
        this.jje = (TBSpecificationBtn) this.mView.findViewById(R.id.btn_open);
        this.jje.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.jje.setText(tbPageContext.getString(R.string.go_to_open));
        this.jje.setOnClickListener(this.mOnClickListener);
        TiebaStatic.log("c13704");
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mView;
    }

    public void onChangeSkinType(int i) {
        an.setBackgroundColor(this.mView, R.color.cp_bg_line_g);
        SvgManager.aWQ().a(this.eVv, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        an.setViewTextColor(this.jjd, (int) R.color.cp_cont_j);
    }

    public void a(a aVar) {
        this.jjf = aVar;
    }
}
