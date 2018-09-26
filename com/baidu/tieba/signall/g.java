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
    private SignAllForumActivity gMA;
    private c gMg;
    private boolean isDestory;
    private ArrayList<d> cWF = new ArrayList<>();
    private HashMap<String, SignSingleModel> gMB = new HashMap<>();
    private boolean deA = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.gMA = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.gMg = cVar;
            this.cWF = cVar.buT();
            if (this.cWF.size() == 0) {
                this.deA = false;
            } else {
                this.deA = true;
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
        if (this.deA) {
            return this.cWF.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cWF.size() > i) {
            return this.cWF.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View tM(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.gMA.getPageContext().getPageActivity()).inflate(e.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.gMH = (BarImageView) inflate.findViewById(e.g.signallforum_item_avatar);
            bVar.gMH.setIsRound(false);
            bVar.gMH.setGifIconSupport(false);
            bVar.gMJ = (TextView) inflate.findViewById(e.g.signallforum_item_name);
            bVar.gMK = (ImageView) inflate.findViewById(e.g.signallforum_item_level);
            bVar.gML = (TextView) inflate.findViewById(e.g.signallforum_item_exp);
            bVar.gMM = (FrameLayout) inflate.findViewById(e.g.signallforum_item_res_container);
            bVar.gMN = (TextView) inflate.findViewById(e.g.signallforum_item_days);
            bVar.gMO = (RelativeLayout) inflate.findViewById(e.g.signallforum_item_resign_container);
            bVar.gMP = (ImageView) inflate.findViewById(e.g.signallforum_item_resign_icon);
            bVar.gMQ = (ProgressBar) inflate.findViewById(e.g.signallforum_item_resign_progress);
            bVar.gMR = (TextView) inflate.findViewById(e.g.signallforum_item_resign_text);
            bVar.gMS = (TextView) inflate.findViewById(e.g.signallforum_item_error);
            bVar.gMI = (LinearLayout) inflate.findViewById(e.g.signallforum_item_level_container);
            bVar.gMT = (TextView) inflate.findViewById(e.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.gMA.getPageContext().getPageActivity()).inflate(e.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.gMF = (TextView) inflate2.findViewById(e.g.signallforum_head_title);
        aVar.gMG = (TextView) inflate2.findViewById(e.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.gMA.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gMA.getLayoutMode().onModeChanged(view);
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
            bVar.gMJ.setText(str);
            al.c(bVar.gMK, BitmapHelper.getSmallGradeResourceIdNew(dVar.bvg()));
            bVar.gML.setText(dVar.bvh() + "/" + dVar.bvi());
            bVar.gMT.clearAnimation();
            if (dVar.VN()) {
                bVar.gMI.setVisibility(0);
                bVar.gMS.setVisibility(8);
                bVar.gMN.setVisibility(0);
                bVar.gMO.setVisibility(8);
                bVar.gMN.setText(String.format(this.gMA.getPageContext().getString(e.j.signallforum_days), Integer.valueOf(dVar.bvf())));
                if (dVar.bvm()) {
                    bVar.gML.setText(this.gMA.getPageContext().getString(e.j.signallforum_uplevel));
                    bVar.gMT.setVisibility(8);
                } else {
                    bVar.gML.setText(dVar.bvh() + "/" + dVar.bvi());
                    bVar.gMT.setVisibility(0);
                }
                int bvl = dVar.bvl();
                if (bvl > 0) {
                    bVar.gMT.setVisibility(0);
                    bVar.gMT.setText("+" + bvl);
                } else {
                    bVar.gMT.setVisibility(8);
                }
            } else if (dVar.bvj()) {
                bVar.gMI.setVisibility(0);
                bVar.gMS.setVisibility(8);
                bVar.gMT.setVisibility(8);
                bVar.gMN.setVisibility(8);
                bVar.gMO.setVisibility(0);
                if (dVar.bvk()) {
                    bVar.gMP.setVisibility(4);
                    bVar.gMQ.setVisibility(0);
                    bVar.gMR.setText(e.j.signallforum_resigning);
                } else {
                    bVar.gMP.setVisibility(0);
                    bVar.gMQ.setVisibility(4);
                    bVar.gMR.setText(e.j.signallforum_resign);
                }
                bVar.gMO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.bvk()) {
                            bVar.gMP.setVisibility(4);
                            bVar.gMQ.setVisibility(0);
                            bVar.gMR.setText(e.j.signallforum_resigning);
                            dVar.mC(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.gMA);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.gMB.put(str2, signSingleModel);
                            }
                            signSingleModel.cq(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.gMN.setVisibility(8);
                bVar.gMO.setVisibility(8);
                bVar.gMT.setVisibility(8);
                bVar.gMI.setVisibility(0);
                bVar.gMS.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.gMH.setTag(avatar);
            bVar.gMH.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.deA) {
            return ast();
        }
        int itemViewType = getItemViewType(i);
        View tM = view == null ? tM(itemViewType) : view;
        if (itemViewType == 1) {
            if (tM.getTag() != null && (tM.getTag() instanceof a)) {
                view2 = tM;
                aVar = (a) tM.getTag();
            } else {
                View tM2 = tM(itemViewType);
                view2 = tM2;
                aVar = (a) tM2.getTag();
            }
            this.gMA.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gMA.getLayoutMode().onModeChanged(view2.findViewById(e.g.sign_all_forum_tip));
            aVar.gMF.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            n(aVar.gMG, i);
            return view2;
        }
        if (tM.getTag() == null || !(tM.getTag() instanceof b)) {
            tM = tM(itemViewType);
        }
        a(tM, viewGroup, i);
        return tM;
    }

    private void n(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.gMg == null ? 7 : this.gMg.getLevel();
        if (this.cWF == null || this.cWF.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.cWF.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.bvg() >= level) {
                        if (next.VN()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.VN()) {
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
            format = String.format(this.gMA.getPageContext().getString(e.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.gMA.getPageContext().getString(e.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View ast() {
        View inflate = LayoutInflater.from(this.gMA.getPageContext().getPageActivity()).inflate(e.h.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.gMA.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(e.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.G(e.j.sign_all_forum_nodata_tip, e.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gMA.getLayoutMode().setNightMode(skinType == 1);
        this.gMA.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.gMA.getPageContext(), skinType);
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
        public BarImageView gMH;
        public LinearLayout gMI;
        public TextView gMJ;
        public ImageView gMK;
        public TextView gML;
        public FrameLayout gMM;
        public TextView gMN;
        public RelativeLayout gMO;
        public ImageView gMP;
        public ProgressBar gMQ;
        public TextView gMR;
        public TextView gMS;
        public TextView gMT;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public TextView gMF;
        public TextView gMG;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.gMB.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void cp(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.gMA.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.gMB.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.cWF.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.cWF.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.mA(z);
                dVar.mB(!z);
                dVar.mC(false);
                if (z) {
                    dVar.tJ(signData.count_sign_num);
                    dVar.tL(signData.sign_bonus_point);
                    dVar.tI(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> buW = this.gMg.buW();
                    if (buW.contains(dVar)) {
                        buW.remove(dVar);
                        this.gMg.buV().add(dVar);
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

    public void bvs() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.gMB.entrySet()) {
                    entry.getValue().bvM();
                }
                this.gMB.clear();
            }
        }
    }
}
