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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
import com.baidu.tieba.signall.SignSingleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private SignAllForumActivity gDL;
    private c gDs;
    private boolean isDestory;
    private ArrayList<d> cOi = new ArrayList<>();
    private HashMap<String, SignSingleModel> gDM = new HashMap<>();
    private boolean cVS = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.gDL = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.gDs = cVar;
            this.cOi = cVar.btK();
            if (this.cOi.size() == 0) {
                this.cVS = false;
            } else {
                this.cVS = true;
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
        if (this.cVS) {
            return this.cOi.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cOi.size() > i) {
            return this.cOi.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View to(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.gDL.getPageContext().getPageActivity()).inflate(d.i.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.gDS = (BarImageView) inflate.findViewById(d.g.signallforum_item_avatar);
            bVar.gDS.setIsRound(false);
            bVar.gDS.setGifIconSupport(false);
            bVar.gDU = (TextView) inflate.findViewById(d.g.signallforum_item_name);
            bVar.gDV = (ImageView) inflate.findViewById(d.g.signallforum_item_level);
            bVar.gDW = (TextView) inflate.findViewById(d.g.signallforum_item_exp);
            bVar.gDX = (FrameLayout) inflate.findViewById(d.g.signallforum_item_res_container);
            bVar.gDY = (TextView) inflate.findViewById(d.g.signallforum_item_days);
            bVar.gDZ = (RelativeLayout) inflate.findViewById(d.g.signallforum_item_resign_container);
            bVar.gEa = (ImageView) inflate.findViewById(d.g.signallforum_item_resign_icon);
            bVar.gEb = (ProgressBar) inflate.findViewById(d.g.signallforum_item_resign_progress);
            bVar.gEc = (TextView) inflate.findViewById(d.g.signallforum_item_resign_text);
            bVar.gEd = (TextView) inflate.findViewById(d.g.signallforum_item_error);
            bVar.gDT = (LinearLayout) inflate.findViewById(d.g.signallforum_item_level_container);
            bVar.gEe = (TextView) inflate.findViewById(d.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.gDL.getPageContext().getPageActivity()).inflate(d.i.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.gDQ = (TextView) inflate2.findViewById(d.g.signallforum_head_title);
        aVar.gDR = (TextView) inflate2.findViewById(d.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.gDL.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.gDL.getLayoutMode().onModeChanged(view);
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
            bVar.gDU.setText(str);
            am.c(bVar.gDV, BitmapHelper.getSmallGradeResourceIdNew(dVar.btX()));
            bVar.gDW.setText(dVar.btY() + "/" + dVar.btZ());
            bVar.gEe.clearAnimation();
            if (dVar.TP()) {
                bVar.gDT.setVisibility(0);
                bVar.gEd.setVisibility(8);
                bVar.gDY.setVisibility(0);
                bVar.gDZ.setVisibility(8);
                bVar.gDY.setText(String.format(this.gDL.getPageContext().getString(d.k.signallforum_days), Integer.valueOf(dVar.btW())));
                if (dVar.bud()) {
                    bVar.gDW.setText(this.gDL.getPageContext().getString(d.k.signallforum_uplevel));
                    bVar.gEe.setVisibility(8);
                } else {
                    bVar.gDW.setText(dVar.btY() + "/" + dVar.btZ());
                    bVar.gEe.setVisibility(0);
                }
                int buc = dVar.buc();
                if (buc > 0) {
                    bVar.gEe.setVisibility(0);
                    bVar.gEe.setText("+" + buc);
                } else {
                    bVar.gEe.setVisibility(8);
                }
            } else if (dVar.bua()) {
                String errorMsg = dVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.gDT.setVisibility(8);
                    bVar.gEd.setVisibility(0);
                    bVar.gEe.setVisibility(8);
                    bVar.gEd.setText(errorMsg);
                } else {
                    bVar.gDT.setVisibility(0);
                    bVar.gEd.setVisibility(8);
                    bVar.gEe.setVisibility(8);
                }
                bVar.gDY.setVisibility(8);
                bVar.gDZ.setVisibility(0);
                if (dVar.bub()) {
                    bVar.gEa.setVisibility(4);
                    bVar.gEb.setVisibility(0);
                    bVar.gEc.setText(d.k.signallforum_resigning);
                } else {
                    bVar.gEa.setVisibility(0);
                    bVar.gEb.setVisibility(4);
                    bVar.gEc.setText(d.k.signallforum_resign);
                }
                bVar.gDZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.bub()) {
                            bVar.gEa.setVisibility(4);
                            bVar.gEb.setVisibility(0);
                            bVar.gEc.setText(d.k.signallforum_resigning);
                            dVar.mu(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.gDL);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.gDM.put(str2, signSingleModel);
                            }
                            signSingleModel.cj(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.gDY.setVisibility(8);
                bVar.gDZ.setVisibility(8);
                bVar.gEe.setVisibility(8);
                bVar.gDT.setVisibility(0);
                bVar.gEd.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.gDS.setTag(avatar);
            bVar.gDS.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.cVS) {
            return aqf();
        }
        int itemViewType = getItemViewType(i);
        View view3 = view == null ? to(itemViewType) : view;
        if (itemViewType == 1) {
            if (view3.getTag() != null && (view3.getTag() instanceof a)) {
                view2 = view3;
                aVar = (a) view3.getTag();
            } else {
                View view4 = to(itemViewType);
                view2 = view4;
                aVar = (a) view4.getTag();
            }
            this.gDL.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.gDL.getLayoutMode().onModeChanged(view2.findViewById(d.g.sign_all_forum_tip));
            aVar.gDQ.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            n(aVar.gDR, i);
            return view2;
        }
        if (view3.getTag() == null || !(view3.getTag() instanceof b)) {
            view3 = to(itemViewType);
        }
        a(view3, viewGroup, i);
        return view3;
    }

    private void n(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.gDs == null ? 7 : this.gDs.getLevel();
        if (this.cOi == null || this.cOi.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.cOi.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.btX() >= level) {
                        if (next.TP()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.TP()) {
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
            format = String.format(this.gDL.getPageContext().getString(d.k.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.gDL.getPageContext().getString(d.k.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View aqf() {
        View inflate = LayoutInflater.from(this.gDL.getPageContext().getPageActivity()).inflate(d.i.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.gDL.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(d.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.D(d.k.sign_all_forum_nodata_tip, d.k.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gDL.getLayoutMode().setNightMode(skinType == 1);
        this.gDL.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.gDL.getPageContext(), skinType);
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
        public BarImageView gDS;
        public LinearLayout gDT;
        public TextView gDU;
        public ImageView gDV;
        public TextView gDW;
        public FrameLayout gDX;
        public TextView gDY;
        public RelativeLayout gDZ;
        public ImageView gEa;
        public ProgressBar gEb;
        public TextView gEc;
        public TextView gEd;
        public TextView gEe;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a {
        public TextView gDQ;
        public TextView gDR;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.gDM.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void ci(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.gDL.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.gDM.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.cOi.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.cOi.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.ms(z);
                dVar.mt(!z);
                dVar.mu(false);
                if (z) {
                    dVar.tl(signData.count_sign_num);
                    dVar.tn(signData.sign_bonus_point);
                    dVar.tk(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> btN = this.gDs.btN();
                    if (btN.contains(dVar)) {
                        btN.remove(dVar);
                        this.gDs.btM().add(dVar);
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

    public void bui() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.gDM.entrySet()) {
                    entry.getValue().buC();
                }
                this.gDM.clear();
            }
        }
    }
}
