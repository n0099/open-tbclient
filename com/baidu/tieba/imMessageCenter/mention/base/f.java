package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class f {
    private ImageView fbc;
    private TextView jrG;
    private TBSpecificationBtn jrH;
    private a jrI;
    private com.baidu.adp.base.e mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.base.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == f.this.jrH.getId()) {
                com.baidu.tbadk.coreExtra.c.a.f(f.this.mContext);
                TiebaStatic.log(new ap("c13705").ah("obj_type", 1));
            } else if (view.getId() == f.this.fbc.getId()) {
                com.baidu.tbadk.core.sharedPref.b.aZP().putLong("key_im_open_notification_close_time", System.currentTimeMillis());
                if (f.this.jrI != null) {
                    f.this.jrI.onClose();
                }
                TiebaStatic.log(new ap("c13705").ah("obj_type", 2));
            }
        }
    };
    private View mView;

    /* loaded from: classes16.dex */
    public interface a {
        void onClose();
    }

    public f(com.baidu.adp.base.e eVar) {
        this.mContext = eVar;
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.open_notification_view, (ViewGroup) null);
        this.fbc = (ImageView) this.mView.findViewById(R.id.img_close);
        this.fbc.setOnClickListener(this.mOnClickListener);
        this.jrG = (TextView) this.mView.findViewById(R.id.open_desc);
        this.jrH = (TBSpecificationBtn) this.mView.findViewById(R.id.btn_open);
        this.jrH.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.jrH.setText(eVar.getString(R.string.go_to_open));
        this.jrH.setOnClickListener(this.mOnClickListener);
        TiebaStatic.log("c13704");
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mView;
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mView, R.color.cp_bg_line_g);
        SvgManager.baR().a(this.fbc, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setViewTextColor(this.jrG, R.color.cp_cont_j);
    }

    public void a(a aVar) {
        this.jrI = aVar;
    }
}
