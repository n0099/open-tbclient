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
/* loaded from: classes6.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.a {
    private boolean isDestory;
    private c jab;
    private SignAllForumActivity jav;
    private ArrayList<d> eYW = new ArrayList<>();
    private HashMap<String, SignSingleModel> jaw = new HashMap<>();
    private boolean fkX = true;

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.jav = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.jab = cVar;
            this.eYW = cVar.clD();
            if (this.eYW.size() == 0) {
                this.fkX = false;
            } else {
                this.fkX = true;
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
        if (this.fkX) {
            return this.eYW.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eYW.size() > i) {
            return this.eYW.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View zB(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.jav.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.jaC = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
            bVar.jaC.setIsRound(false);
            bVar.jaC.setGifIconSupport(false);
            bVar.jaE = (TextView) inflate.findViewById(R.id.signallforum_item_name);
            bVar.jaF = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
            bVar.jaG = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
            bVar.jaH = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
            bVar.jaI = (TextView) inflate.findViewById(R.id.signallforum_item_days);
            bVar.jaJ = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
            bVar.jaK = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
            bVar.jaL = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
            bVar.jaM = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
            bVar.jaN = (TextView) inflate.findViewById(R.id.signallforum_item_error);
            bVar.jaD = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
            bVar.jaO = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.jav.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.jaA = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
        aVar.jaB = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.jav.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.jav.getLayoutMode().onModeChanged(view);
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
            bVar.jaE.setText(str);
            am.setImageResource(bVar.jaF, BitmapHelper.getSmallGradeResourceIdNew(dVar.clQ()));
            bVar.jaG.setText(dVar.clR() + "/" + dVar.clS());
            bVar.jaO.clearAnimation();
            if (dVar.aJX()) {
                bVar.jaD.setVisibility(0);
                bVar.jaN.setVisibility(8);
                bVar.jaI.setVisibility(0);
                bVar.jaJ.setVisibility(8);
                bVar.jaI.setText(String.format(this.jav.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.clP())));
                if (dVar.clW()) {
                    bVar.jaG.setText(this.jav.getPageContext().getString(R.string.signallforum_uplevel));
                    bVar.jaO.setVisibility(8);
                } else {
                    bVar.jaG.setText(dVar.clR() + "/" + dVar.clS());
                    bVar.jaO.setVisibility(0);
                }
                int clV = dVar.clV();
                if (clV > 0) {
                    bVar.jaO.setVisibility(0);
                    bVar.jaO.setText("+" + clV);
                } else {
                    bVar.jaO.setVisibility(8);
                }
            } else if (dVar.clT()) {
                bVar.jaD.setVisibility(0);
                bVar.jaN.setVisibility(8);
                bVar.jaO.setVisibility(8);
                bVar.jaI.setVisibility(8);
                bVar.jaJ.setVisibility(0);
                if (dVar.clU()) {
                    bVar.jaK.setVisibility(4);
                    bVar.jaL.setVisibility(0);
                    bVar.jaM.setText(R.string.signallforum_resigning);
                } else {
                    bVar.jaK.setVisibility(0);
                    bVar.jaL.setVisibility(4);
                    bVar.jaM.setText(R.string.signallforum_resign);
                }
                bVar.jaJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.g.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (!dVar.clU()) {
                            bVar.jaK.setVisibility(4);
                            bVar.jaL.setVisibility(0);
                            bVar.jaM.setText(R.string.signallforum_resigning);
                            dVar.qD(true);
                            SignSingleModel signSingleModel = new SignSingleModel(g.this.jav);
                            signSingleModel.a(g.this);
                            String str2 = dVar.getForumId() + "";
                            synchronized (g.this) {
                                g.this.jaw.put(str2, signSingleModel);
                            }
                            signSingleModel.dT(dVar.getForumName(), str2);
                            TiebaStatic.log("signall_resign_click");
                        }
                    }
                });
            } else {
                bVar.jaI.setVisibility(8);
                bVar.jaJ.setVisibility(8);
                bVar.jaO.setVisibility(8);
                bVar.jaD.setVisibility(0);
                bVar.jaN.setVisibility(8);
            }
            String avatar = dVar.getAvatar();
            bVar.jaC.setTag(avatar);
            bVar.jaC.startLoad(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.fkX) {
            return bgV();
        }
        int itemViewType = getItemViewType(i);
        View zB = view == null ? zB(itemViewType) : view;
        if (itemViewType == 1) {
            if (zB.getTag() != null && (zB.getTag() instanceof a)) {
                view2 = zB;
                aVar = (a) zB.getTag();
            } else {
                View zB2 = zB(itemViewType);
                view2 = zB2;
                aVar = (a) zB2.getTag();
            }
            this.jav.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.jav.getLayoutMode().onModeChanged(view2.findViewById(R.id.sign_all_forum_tip));
            aVar.jaA.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            h(aVar.jaB, i);
            return view2;
        }
        if (zB.getTag() == null || !(zB.getTag() instanceof b)) {
            zB = zB(itemViewType);
        }
        a(zB, viewGroup, i);
        return zB;
    }

    private void h(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.jab == null ? 7 : this.jab.getLevel();
        if (this.eYW == null || this.eYW.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<d> it = this.eYW.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                d next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.clQ() >= level) {
                        if (next.aJX()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.aJX()) {
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
            format = String.format(this.jav.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.jav.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View bgV() {
        View inflate = LayoutInflater.from(this.jav.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
        NoDataView a2 = NoDataViewFactory.a(this.jav.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.ak(R.string.sign_all_forum_nodata_tip, R.string.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jav.getLayoutMode().setNightMode(skinType == 1);
        this.jav.getLayoutMode().onModeChanged(inflate);
        a2.onChangeSkinType(this.jav.getPageContext(), skinType);
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
    /* loaded from: classes6.dex */
    public class b {
        public BarImageView jaC;
        public LinearLayout jaD;
        public TextView jaE;
        public ImageView jaF;
        public TextView jaG;
        public FrameLayout jaH;
        public TextView jaI;
        public RelativeLayout jaJ;
        public ImageView jaK;
        public ProgressBar jaL;
        public TextView jaM;
        public TextView jaN;
        public TextView jaO;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a {
        public TextView jaA;
        public TextView jaB;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void b(SignData signData) {
        String str = signData.forumId;
        synchronized (this) {
            this.jaw.remove(str);
        }
        a(str, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.a
    public void dS(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            l.showToast(this.jav.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.jaw.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.eYW.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.eYW.get(i);
            if ((dVar.getForumId() + "").equals(str)) {
                dVar.qB(z);
                dVar.qC(!z);
                dVar.qD(false);
                if (z) {
                    dVar.zy(signData.count_sign_num);
                    dVar.zA(signData.sign_bonus_point);
                    dVar.zx(1);
                    TbadkApplication.getInst().addSignedForum(dVar.getForumName(), signData.sign_bonus_point, -1);
                    ArrayList<d> clG = this.jab.clG();
                    if (clG.contains(dVar)) {
                        clG.remove(dVar);
                        this.jab.clF().add(dVar);
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

    public void cmc() {
        this.isDestory = true;
        synchronized (this) {
            try {
                for (Map.Entry<String, SignSingleModel> entry : this.jaw.entrySet()) {
                    entry.getValue().cmv();
                }
                this.jaw.clear();
            }
        }
    }
}
