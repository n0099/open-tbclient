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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.e;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private c gVe;
    private SignAllForumActivity gVy;
    private boolean isDestory;
    private ArrayList<d> dgc = new ArrayList<>();
    private HashMap<String, SignSingleModel> gVz = new HashMap<>();
    private boolean dnK = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.gVy = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.gVe = cVar;
            this.dgc = cVar.bxE();
            if (this.dgc.size() == 0) {
                this.dnK = false;
            } else {
                this.dnK = true;
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
        if (this.dnK) {
            return this.dgc.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dgc.size() > i) {
            return this.dgc.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View uC(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.gVy.getPageContext().getPageActivity()).inflate(e.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.gVF = (BarImageView) inflate.findViewById(e.g.signallforum_item_avatar);
            bVar.gVF.setIsRound(false);
            bVar.gVF.setGifIconSupport(false);
            bVar.gVH = (TextView) inflate.findViewById(e.g.signallforum_item_name);
            bVar.gVI = (ImageView) inflate.findViewById(e.g.signallforum_item_level);
            bVar.gVJ = (TextView) inflate.findViewById(e.g.signallforum_item_exp);
            bVar.gVK = (FrameLayout) inflate.findViewById(e.g.signallforum_item_res_container);
            bVar.gVL = (TextView) inflate.findViewById(e.g.signallforum_item_days);
            bVar.gVM = (RelativeLayout) inflate.findViewById(e.g.signallforum_item_resign_container);
            bVar.gVN = (ImageView) inflate.findViewById(e.g.signallforum_item_resign_icon);
            bVar.gVO = (ProgressBar) inflate.findViewById(e.g.signallforum_item_resign_progress);
            bVar.gVP = (TextView) inflate.findViewById(e.g.signallforum_item_resign_text);
            bVar.gVQ = (TextView) inflate.findViewById(e.g.signallforum_item_error);
            bVar.gVG = (LinearLayout) inflate.findViewById(e.g.signallforum_item_level_container);
            bVar.gVR = (TextView) inflate.findViewById(e.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.gVy.getPageContext().getPageActivity()).inflate(e.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.gVD = (TextView) inflate2.findViewById(e.g.signallforum_head_title);
        aVar.gVE = (TextView) inflate2.findViewById(e.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.gVy.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gVy.getLayoutMode().onModeChanged(view);
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
                        str = forumName.substring(0, i3) + "...";
                        break;
                    }
                }
            }
            str = forumName;
            bVar.gVH.setText(str);
            al.c(bVar.gVI, BitmapHelper.getSmallGradeResourceIdNew(dVar.bxR()));
            bVar.gVJ.setText(dVar.bxS() + "/" + dVar.bxT());
            bVar.gVR.clearAnimation();
            if (dVar.ZF()) {
                bVar.gVG.setVisibility(0);
                bVar.gVQ.setVisibility(8);
                bVar.gVL.setVisibility(0);
                bVar.gVM.setVisibility(8);
                bVar.gVL.setText(String.format(this.gVy.getPageContext().getString(e.j.signallforum_days), Integer.valueOf(dVar.bxQ())));
                if (dVar.bxX()) {
                    bVar.gVJ.setText(this.gVy.getPageContext().getString(e.j.signallforum_uplevel));
                    bVar.gVR.setVisibility(8);
                } else {
                    bVar.gVJ.setText(dVar.bxS() + "/" + dVar.bxT());
                    bVar.gVR.setVisibility(0);
                }
                int bxW = dVar.bxW();
                if (bxW > 0) {
                    bVar.gVR.setVisibility(0);
                    bVar.gVR.setText("+" + bxW);
                } else {
                    bVar.gVR.setVisibility(8);
                }
            } else if (dVar.bxU()) {
                bVar.gVG.setVisibility(0);
                bVar.gVQ.setVisibility(8);
                bVar.gVR.setVisibility(8);
                bVar.gVL.setVisibility(8);
                bVar.gVM.setVisibility(0);
                if (dVar.bxV()) {
                    bVar.gVN.setVisibility(4);
                    bVar.gVO.setVisibility(0);
                    bVar.gVP.setText(e.j.signallforum_resigning);
                } else {
                    bVar.gVN.setVisibility(0);
                    bVar.gVO.setVisibility(4);
                    bVar.gVP.setText(e.j.signallforum_resign);
                }
                bVar.gVM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.bxV()) {
                            bVar.gVN.setVisibility(4);
                            bVar.gVO.setVisibility(0);
                            bVar.gVP.setText(e.j.signallforum_resigning);
                            dVar.nf(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.gVy);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.gVz.put(str2, signSingleModel);
                            }
                            signSingleModel.cB(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.gVL.setVisibility(8);
                bVar.gVM.setVisibility(8);
                bVar.gVR.setVisibility(8);
                bVar.gVG.setVisibility(0);
                bVar.gVQ.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.gVF.setTag(avatar);
            bVar.gVF.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.dnK) {
            return avo();
        }
        int itemViewType = getItemViewType(i);
        View uC = view == null ? uC(itemViewType) : view;
        if (itemViewType == 1) {
            if (uC.getTag() != null && (uC.getTag() instanceof a)) {
                view2 = uC;
                aVar = (a) uC.getTag();
            } else {
                View uC2 = uC(itemViewType);
                view2 = uC2;
                aVar = (a) uC2.getTag();
            }
            this.gVy.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gVy.getLayoutMode().onModeChanged(view2.findViewById(e.g.sign_all_forum_tip));
            aVar.gVD.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            n(aVar.gVE, i);
            return view2;
        }
        if (uC.getTag() == null || !(uC.getTag() instanceof b)) {
            uC = uC(itemViewType);
        }
        a(uC, viewGroup, i);
        return uC;
    }

    private void n(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.gVe == null ? 7 : this.gVe.getLevel();
        if (this.dgc == null || this.dgc.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.dgc.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.bxR() >= level) {
                        if (next.ZF()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.ZF()) {
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
            format = String.format(this.gVy.getPageContext().getString(e.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.gVy.getPageContext().getString(e.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View avo() {
        View inflate = LayoutInflater.from(this.gVy.getPageContext().getPageActivity()).inflate(e.h.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.gVy.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(e.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.G(e.j.sign_all_forum_nodata_tip, e.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gVy.getLayoutMode().setNightMode(skinType == 1);
        this.gVy.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.gVy.getPageContext(), skinType);
        a2.setVisibility(0);
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
    /* loaded from: classes3.dex */
    public class b {
        public BarImageView gVF;
        public LinearLayout gVG;
        public TextView gVH;
        public ImageView gVI;
        public TextView gVJ;
        public FrameLayout gVK;
        public TextView gVL;
        public RelativeLayout gVM;
        public ImageView gVN;
        public ProgressBar gVO;
        public TextView gVP;
        public TextView gVQ;
        public TextView gVR;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public TextView gVD;
        public TextView gVE;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.gVz.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void cA(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.gVy.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.gVz.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.dgc.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.dgc.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.nd(z);
                dVar.ne(!z);
                dVar.nf(false);
                if (z) {
                    dVar.uz(signData.count_sign_num);
                    dVar.uB(signData.sign_bonus_point);
                    dVar.uy(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> bxH = this.gVe.bxH();
                    if (bxH.contains(dVar)) {
                        bxH.remove(dVar);
                        this.gVe.bxG().add(dVar);
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

    public void byd() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.gVz.entrySet()) {
                    entry.getValue().byx();
                }
                this.gVz.clear();
            }
        }
    }
}
