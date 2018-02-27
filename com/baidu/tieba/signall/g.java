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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private c gRC;
    private SignAllForumActivity gRV;
    private boolean isDestory;
    private ArrayList<d> dnR = new ArrayList<>();
    private HashMap<String, SignSingleModel> gRW = new HashMap<>();
    private boolean duP = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.gRV = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.gRC = cVar;
            this.dnR = cVar.btc();
            if (this.dnR.size() == 0) {
                this.duP = false;
            } else {
                this.duP = true;
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
        if (this.duP) {
            return this.dnR.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dnR.size() > i) {
            return this.dnR.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View vr(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.gRV.getPageContext().getPageActivity()).inflate(d.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.gSc = (BarImageView) inflate.findViewById(d.g.signallforum_item_avatar);
            bVar.gSc.setIsRound(false);
            bVar.gSc.setGifIconSupport(false);
            bVar.gSe = (TextView) inflate.findViewById(d.g.signallforum_item_name);
            bVar.gSf = (ImageView) inflate.findViewById(d.g.signallforum_item_level);
            bVar.gSg = (TextView) inflate.findViewById(d.g.signallforum_item_exp);
            bVar.gSh = (FrameLayout) inflate.findViewById(d.g.signallforum_item_res_container);
            bVar.gSi = (TextView) inflate.findViewById(d.g.signallforum_item_days);
            bVar.gSj = (RelativeLayout) inflate.findViewById(d.g.signallforum_item_resign_container);
            bVar.gSk = (ImageView) inflate.findViewById(d.g.signallforum_item_resign_icon);
            bVar.gSl = (ProgressBar) inflate.findViewById(d.g.signallforum_item_resign_progress);
            bVar.gSm = (TextView) inflate.findViewById(d.g.signallforum_item_resign_text);
            bVar.gSn = (TextView) inflate.findViewById(d.g.signallforum_item_error);
            bVar.gSd = (LinearLayout) inflate.findViewById(d.g.signallforum_item_level_container);
            bVar.gSo = (TextView) inflate.findViewById(d.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.gRV.getPageContext().getPageActivity()).inflate(d.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.gSa = (TextView) inflate2.findViewById(d.g.signallforum_head_title);
        aVar.gSb = (TextView) inflate2.findViewById(d.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void d(View view, View view2, int i) {
        String str;
        this.gRV.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gRV.getLayoutMode().aM(view);
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
            bVar.gSe.setText(str);
            aj.c(bVar.gSf, BitmapHelper.getSmallGradeResourceIdNew(dVar.btp()));
            bVar.gSg.setText(dVar.btq() + "/" + dVar.btr());
            bVar.gSo.clearAnimation();
            if (dVar.Xz()) {
                bVar.gSd.setVisibility(0);
                bVar.gSn.setVisibility(8);
                bVar.gSi.setVisibility(0);
                bVar.gSj.setVisibility(8);
                bVar.gSi.setText(String.format(this.gRV.getPageContext().getString(d.j.signallforum_days), Integer.valueOf(dVar.bto())));
                if (dVar.btv()) {
                    bVar.gSg.setText(this.gRV.getPageContext().getString(d.j.signallforum_uplevel));
                    bVar.gSo.setVisibility(8);
                } else {
                    bVar.gSg.setText(dVar.btq() + "/" + dVar.btr());
                    bVar.gSo.setVisibility(0);
                }
                int btu = dVar.btu();
                if (btu > 0) {
                    bVar.gSo.setVisibility(0);
                    bVar.gSo.setText("+" + btu);
                } else {
                    bVar.gSo.setVisibility(8);
                }
            } else if (dVar.bts()) {
                String errorMsg = dVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.gSd.setVisibility(8);
                    bVar.gSn.setVisibility(0);
                    bVar.gSo.setVisibility(8);
                    bVar.gSn.setText(errorMsg);
                } else {
                    bVar.gSd.setVisibility(0);
                    bVar.gSn.setVisibility(8);
                    bVar.gSo.setVisibility(8);
                }
                bVar.gSi.setVisibility(8);
                bVar.gSj.setVisibility(0);
                if (dVar.btt()) {
                    bVar.gSk.setVisibility(4);
                    bVar.gSl.setVisibility(0);
                    bVar.gSm.setText(d.j.signallforum_resigning);
                } else {
                    bVar.gSk.setVisibility(0);
                    bVar.gSl.setVisibility(4);
                    bVar.gSm.setText(d.j.signallforum_resign);
                }
                bVar.gSj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.btt()) {
                            bVar.gSk.setVisibility(4);
                            bVar.gSl.setVisibility(0);
                            bVar.gSm.setText(d.j.signallforum_resigning);
                            dVar.mw(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.gRV);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.gRW.put(str2, signSingleModel);
                            }
                            signSingleModel.bY(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.gSi.setVisibility(8);
                bVar.gSj.setVisibility(8);
                bVar.gSo.setVisibility(8);
                bVar.gSd.setVisibility(0);
                bVar.gSn.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.gSc.setTag(avatar);
            bVar.gSc.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.duP) {
            return aso();
        }
        int itemViewType = getItemViewType(i);
        View vr = view == null ? vr(itemViewType) : view;
        if (itemViewType == 1) {
            if (vr.getTag() != null && (vr.getTag() instanceof a)) {
                view2 = vr;
                aVar = (a) vr.getTag();
            } else {
                View vr2 = vr(itemViewType);
                view2 = vr2;
                aVar = (a) vr2.getTag();
            }
            this.gRV.getLayoutMode().aQ(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gRV.getLayoutMode().aM(view2.findViewById(d.g.sign_all_forum_tip));
            aVar.gSa.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            p(aVar.gSb, i);
            return view2;
        }
        if (vr.getTag() == null || !(vr.getTag() instanceof b)) {
            vr = vr(itemViewType);
        }
        d(vr, viewGroup, i);
        return vr;
    }

    private void p(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.gRC == null ? 7 : this.gRC.getLevel();
        if (this.dnR == null || this.dnR.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.dnR.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.btp() >= level) {
                        if (next.Xz()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.Xz()) {
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
            format = String.format(this.gRV.getPageContext().getString(d.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.gRV.getPageContext().getString(d.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View aso() {
        View inflate = LayoutInflater.from(this.gRV.getPageContext().getPageActivity()).inflate(d.h.sign_all_forum_nodata_item, (ViewGroup) null);
        com.baidu.tbadk.core.view.h a2 = NoDataViewFactory.a(this.gRV.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(d.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.aC(d.j.sign_all_forum_nodata_tip, d.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gRV.getLayoutMode().aQ(skinType == 1);
        this.gRV.getLayoutMode().aM(inflate);
        a2.onChangeSkinType(this.gRV.getPageContext(), skinType);
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
        public BarImageView gSc;
        public LinearLayout gSd;
        public TextView gSe;
        public ImageView gSf;
        public TextView gSg;
        public FrameLayout gSh;
        public TextView gSi;
        public RelativeLayout gSj;
        public ImageView gSk;
        public ProgressBar gSl;
        public TextView gSm;
        public TextView gSn;
        public TextView gSo;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public TextView gSa;
        public TextView gSb;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.gRW.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void bX(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.l.showToast(this.gRV.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.gRW.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.dnR.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.dnR.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.mu(z);
                dVar.mv(!z);
                dVar.mw(false);
                if (z) {
                    dVar.vo(signData.count_sign_num);
                    dVar.vq(signData.sign_bonus_point);
                    dVar.vn(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> btf = this.gRC.btf();
                    if (btf.contains(dVar)) {
                        btf.remove(dVar);
                        this.gRC.bte().add(dVar);
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

    public void btA() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.gRW.entrySet()) {
                    entry.getValue().btV();
                }
                this.gRW.clear();
            }
        }
    }
}
