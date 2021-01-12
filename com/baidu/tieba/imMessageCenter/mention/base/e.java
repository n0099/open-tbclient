package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e {
    private ImageView gcW;
    private TextView kLq;
    private TBSpecificationBtn kLr;
    private a kLs;
    private f mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.base.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == e.this.kLr.getId()) {
                com.baidu.tbadk.coreExtra.c.a.f(e.this.mContext);
                TiebaStatic.log(new aq("c13705").an("obj_type", 1));
            } else if (view.getId() == e.this.gcW.getId()) {
                com.baidu.tbadk.core.sharedPref.b.brx().putLong("key_im_open_notification_close_time", System.currentTimeMillis());
                if (e.this.kLs != null) {
                    e.this.kLs.onClose();
                }
                TiebaStatic.log(new aq("c13705").an("obj_type", 2));
            }
        }
    };
    private View mView;

    /* loaded from: classes2.dex */
    public interface a {
        void onClose();
    }

    public e(f fVar) {
        this.mContext = fVar;
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.open_notification_view, (ViewGroup) null);
        this.gcW = (ImageView) this.mView.findViewById(R.id.img_close);
        this.gcW.setOnClickListener(this.mOnClickListener);
        this.kLq = (TextView) this.mView.findViewById(R.id.open_desc);
        this.kLr = (TBSpecificationBtn) this.mView.findViewById(R.id.btn_open);
        this.kLr.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
        this.kLr.setText(fVar.getString(R.string.go_to_open));
        this.kLr.setOnClickListener(this.mOnClickListener);
        TiebaStatic.log("c13704");
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mView;
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mView, R.color.CAM_X0206);
        SvgManager.bsx().a(this.gcW, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setViewTextColor(this.kLq, R.color.CAM_X0107);
    }

    public void a(a aVar) {
        this.kLs = aVar;
    }
}
