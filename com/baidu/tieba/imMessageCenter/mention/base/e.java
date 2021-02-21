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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e {
    private ImageView gfq;
    private TextView kTH;
    private TBSpecificationBtn kTI;
    private a kTJ;
    private f mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.base.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == e.this.kTI.getId()) {
                com.baidu.tbadk.coreExtra.c.a.f(e.this.mContext);
                TiebaStatic.log(new ar("c13705").ap("obj_type", 1));
            } else if (view.getId() == e.this.gfq.getId()) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putLong("key_im_open_notification_close_time", System.currentTimeMillis());
                if (e.this.kTJ != null) {
                    e.this.kTJ.onClose();
                }
                TiebaStatic.log(new ar("c13705").ap("obj_type", 2));
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
        this.gfq = (ImageView) this.mView.findViewById(R.id.img_close);
        this.gfq.setOnClickListener(this.mOnClickListener);
        this.kTH = (TextView) this.mView.findViewById(R.id.open_desc);
        this.kTI = (TBSpecificationBtn) this.mView.findViewById(R.id.btn_open);
        this.kTI.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
        this.kTI.setText(fVar.getString(R.string.go_to_open));
        this.kTI.setOnClickListener(this.mOnClickListener);
        TiebaStatic.log("c13704");
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mView;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mView, R.color.CAM_X0206);
        SvgManager.bsR().a(this.gfq, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.kTH, R.color.CAM_X0107);
    }

    public void a(a aVar) {
        this.kTJ = aVar;
    }
}
