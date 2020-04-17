package com.baidu.tieba.signall;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes11.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private boolean isDestory;
    private SignAllForumActivity kJM;
    private c kJp;
    private ArrayList<d> gxX = new ArrayList<>();
    private HashMap<String, SignSingleModel> kJN = new HashMap<>();
    private boolean gNV = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.kJM = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.kJp = cVar;
            this.gxX = cVar.cTv();
            if (this.gxX.size() == 0) {
                this.gNV = false;
            } else {
                this.gNV = true;
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItem(i) instanceof com.baidu.tieba.signall.b ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gNV) {
            return this.gxX.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gxX.size() > i) {
            return this.gxX.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View CQ(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.kJM.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.kJT = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.kJT.setIsRound(false);
            bVar.kJT.setGifIconSupport(false);
            bVar.kJV = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.kJW = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.kJX = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.kJY = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.kJZ = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.kKa = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.kKb = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.kKc = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.kKd = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.kKe = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.kJU = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.kKf = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.kJM.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.kJR = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.kJS = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.kJM.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.kJM.getLayoutMode().onModeChanged(view);
        final b bVar = (b) view.getTag();
        final d dVar = (d) getItem(i);
        if (dVar != null) {
            String forumName = dVar.getForumName();
            if (forumName != null && forumName.length() > 8) {
                char[] charArray = forumName.toCharArray();
                int i2 = 0;
                for (int i3 = 0; i3 < charArray.length; i3++) {
                    if (StringUtils.isChinese(charArray[i3])) {
                        i2 += 2;
                    } else {
                        i2++;
                    }
                    if (i2 > 16) {
                        str = forumName.substring(0, i3) + StringHelper.STRING_MORE;
                        break;
                    }
                }
            }
            str = forumName;
            bVar.kJV.setText(str);
            am.setImageResource(bVar.kJW, BitmapHelper.getSmallGradeResourceIdNew(dVar.cTI()));
            bVar.kJX.setText(dVar.cTJ() + "/" + dVar.cTK());
            bVar.kKf.clearAnimation();
            if (dVar.bmd()) {
                bVar.kJU.setVisibility(0);
                bVar.kKe.setVisibility(8);
                bVar.kJZ.setVisibility(0);
                bVar.kKa.setVisibility(8);
                bVar.kJZ.setText(String.format(this.kJM.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.cTH())));
                if (dVar.cTO()) {
                    bVar.kJX.setText(this.kJM.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.kKf.setVisibility(8);
                } else {
                    bVar.kJX.setText(dVar.cTJ() + "/" + dVar.cTK());
                    bVar.kKf.setVisibility(0);
                }
                int cTN = dVar.cTN();
                if (cTN > 0) {
                    bVar.kKf.setVisibility(0);
                    bVar.kKf.setText("+" + cTN);
                } else {
                    bVar.kKf.setVisibility(8);
                }
            } else if (dVar.cTL()) {
                bVar.kJU.setVisibility(0);
                bVar.kKe.setVisibility(8);
                bVar.kKf.setVisibility(8);
                bVar.kJZ.setVisibility(8);
                bVar.kKa.setVisibility(0);
                if (dVar.cTM()) {
                    bVar.kKb.setVisibility(4);
                    bVar.kKc.setVisibility(0);
                    bVar.kKd.setText(R.string.signallforum_resigning);
                } else {
                    bVar.kKb.setVisibility(0);
                    bVar.kKc.setVisibility(4);
                    bVar.kKd.setText(R.string.signallforum_resign);
                }
                bVar.kKa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.cTM()) {
                            bVar.kKb.setVisibility(4);
                            bVar.kKc.setVisibility(0);
                            bVar.kKd.setText(R.string.signallforum_resigning);
                            dVar.tI(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.kJM);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.kJN.put(str2, signSingleModel);
                            }
                            signSingleModel.eK(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.kJZ.setVisibility(8);
                bVar.kKa.setVisibility(8);
                bVar.kKf.setVisibility(8);
                bVar.kJU.setVisibility(0);
                bVar.kKe.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.kJT.setTag(avatar);
            bVar.kJT.setPlaceHolder(1);
            bVar.kJT.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.gNV) {
            return bLB();
        }
        int itemViewType = getItemViewType(i);
        View CQ = view == null ? CQ(itemViewType) : view;
        if (itemViewType == 1) {
            if (CQ.getTag() != null && (CQ.getTag() instanceof a)) {
                view2 = CQ;
                aVar = (a) CQ.getTag();
            } else {
                View CQ2 = CQ(itemViewType);
                view2 = CQ2;
                aVar = (a) CQ2.getTag();
            }
            this.kJM.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.kJM.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.kJR.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            h(aVar.kJS, i);
            return view2;
        }
        if (CQ.getTag() == null || !(CQ.getTag() instanceof b)) {
            CQ = CQ(itemViewType);
        }
        a(CQ, viewGroup, i);
        return CQ;
    }

    private void h(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.kJp == null ? 7 : this.kJp.getLevel();
        if (this.gxX == null || this.gxX.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.gxX.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.cTI() >= level) {
                        if (next.bmd()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.bmd()) {
                        i3++;
                    } else {
                        i2++;
                    }
                    i5 = i5;
                    i4 = i4;
                    i3 = i3;
                    i2 = i2;
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.kJM.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.kJM.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View bLB() {
        View inflate = LayoutInflater.from(this.kJM.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.kJM.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.FINDBAR, this.kJM.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.d.cK(null, this.kJM.getResources().getString(R.string.no_bar_attentioned)), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kJM.getLayoutMode().setNightMode(skinType == 1);
        this.kJM.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.kJM.getPageContext(), skinType);
        a2.setVisibility(0);
        a2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return inflate;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b {
        public BarImageView kJT;
        public LinearLayout kJU;
        public TextView kJV;
        public ImageView kJW;
        public TextView kJX;
        public FrameLayout kJY;
        public TextView kJZ;
        public RelativeLayout kKa;
        public ImageView kKb;
        public ProgressBar kKc;
        public TextView kKd;
        public TextView kKe;
        public TextView kKf;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a {
        public TextView kJR;
        public TextView kJS;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void c(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.kJN.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void eJ(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.kJM.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.kJN.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.gxX.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.gxX.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.tG(z);
                dVar.tH(!z);
                dVar.tI(false);
                if (z) {
                    dVar.CN(signData.count_sign_num);
                    dVar.CP(signData.sign_bonus_point);
                    dVar.CM(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> cTy = this.kJp.cTy();
                    if (cTy.contains(dVar)) {
                        cTy.remove(dVar);
                        this.kJp.cTx().add(dVar);
                    }
                } else {
                    dVar.setErrorMsg(str2);
                }
                if (!this.isDestory) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void cTV() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.kJN.entrySet()) {
                    entry.getValue().cUo();
                }
                this.kJN.clear();
            }
        }
    }
}
