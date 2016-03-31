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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.signall.ah;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class p extends BaseAdapter implements AbsListView.OnScrollListener, ah.a {
    private c efP;
    private boolean egd;
    private SignAllForumActivity egk;
    private ArrayList<e> aZF = new ArrayList<>();
    private HashMap<String, ah> egl = new HashMap<>();
    private boolean bgf = true;

    public p(SignAllForumActivity signAllForumActivity, TextView textView) {
        this.egk = signAllForumActivity;
    }

    public void c(c cVar) {
        if (cVar != null) {
            this.efP = cVar;
            this.aZF = cVar.aPy();
            if (this.aZF.size() == 0) {
                this.bgf = false;
            } else {
                this.bgf = true;
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
        if (this.bgf) {
            return this.aZF.size();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aZF.size() > i) {
            return this.aZF.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View oY(int i) {
        if (i == 0) {
            View inflate = LayoutInflater.from(this.egk.getPageContext().getPageActivity()).inflate(t.h.signallforum_item, (ViewGroup) null);
            b bVar = new b();
            bVar.egr = (BarImageView) inflate.findViewById(t.g.signallforum_item_avatar);
            bVar.egr.setIsRound(false);
            bVar.egr.setGifIconSupport(false);
            bVar.egt = (TextView) inflate.findViewById(t.g.signallforum_item_name);
            bVar.egu = (ImageView) inflate.findViewById(t.g.signallforum_item_level);
            bVar.egv = (TextView) inflate.findViewById(t.g.signallforum_item_exp);
            bVar.egw = (FrameLayout) inflate.findViewById(t.g.signallforum_item_res_container);
            bVar.egx = (TextView) inflate.findViewById(t.g.signallforum_item_days);
            bVar.egy = (RelativeLayout) inflate.findViewById(t.g.signallforum_item_resign_container);
            bVar.egz = (ImageView) inflate.findViewById(t.g.signallforum_item_resign_icon);
            bVar.egA = (ProgressBar) inflate.findViewById(t.g.signallforum_item_resign_progress);
            bVar.egB = (TextView) inflate.findViewById(t.g.signallforum_item_resign_text);
            bVar.egC = (TextView) inflate.findViewById(t.g.signallforum_item_error);
            bVar.egs = (LinearLayout) inflate.findViewById(t.g.signallforum_item_level_container);
            bVar.egD = (TextView) inflate.findViewById(t.g.signallforum_item_increaseexp);
            inflate.setTag(bVar);
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.egk.getPageContext().getPageActivity()).inflate(t.h.signallforum_header, (ViewGroup) null);
        a aVar = new a();
        aVar.egp = (TextView) inflate2.findViewById(t.g.signallforum_head_title);
        aVar.egq = (TextView) inflate2.findViewById(t.g.signallforum_head_res);
        inflate2.setTag(aVar);
        return inflate2;
    }

    private void a(View view, View view2, int i) {
        String str;
        this.egk.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.egk.getLayoutMode().x(view);
        b bVar = (b) view.getTag();
        e eVar = (e) getItem(i);
        if (eVar != null) {
            String forumName = eVar.getForumName();
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
                        str = String.valueOf(forumName.substring(0, i3)) + "...";
                        break;
                    }
                }
            }
            str = forumName;
            bVar.egt.setText(str);
            at.c(bVar.egu, BitmapHelper.getSmallGradeResourceIdNew(eVar.getUserLevel()));
            bVar.egv.setText(String.valueOf(eVar.aPL()) + "/" + eVar.aPM());
            bVar.egD.clearAnimation();
            if (eVar.aPN()) {
                bVar.egs.setVisibility(0);
                bVar.egC.setVisibility(8);
                bVar.egx.setVisibility(0);
                bVar.egy.setVisibility(8);
                bVar.egx.setText(String.format(this.egk.getPageContext().getString(t.j.signallforum_days), Integer.valueOf(eVar.aPK())));
                if (eVar.aPR()) {
                    bVar.egv.setText(this.egk.getPageContext().getString(t.j.signallforum_uplevel));
                    bVar.egD.setVisibility(8);
                } else {
                    bVar.egv.setText(String.valueOf(eVar.aPL()) + "/" + eVar.aPM());
                    bVar.egD.setVisibility(0);
                }
                int aPQ = eVar.aPQ();
                if (aPQ > 0) {
                    bVar.egD.setVisibility(0);
                    bVar.egD.setText("+" + aPQ);
                } else {
                    bVar.egD.setVisibility(8);
                }
            } else if (eVar.aPO()) {
                String errorMsg = eVar.getErrorMsg();
                if (!TextUtils.isEmpty(errorMsg)) {
                    bVar.egs.setVisibility(8);
                    bVar.egC.setVisibility(0);
                    bVar.egD.setVisibility(8);
                    bVar.egC.setText(errorMsg);
                } else {
                    bVar.egs.setVisibility(0);
                    bVar.egC.setVisibility(8);
                    bVar.egD.setVisibility(8);
                }
                bVar.egx.setVisibility(8);
                bVar.egy.setVisibility(0);
                if (eVar.aPP()) {
                    bVar.egz.setVisibility(4);
                    bVar.egA.setVisibility(0);
                    bVar.egB.setText(t.j.signallforum_resigning);
                } else {
                    bVar.egz.setVisibility(0);
                    bVar.egA.setVisibility(4);
                    bVar.egB.setText(t.j.signallforum_resign);
                }
                bVar.egy.setOnClickListener(new q(this, eVar, bVar));
            } else {
                bVar.egx.setVisibility(8);
                bVar.egy.setVisibility(8);
                bVar.egD.setVisibility(8);
                bVar.egs.setVisibility(0);
                bVar.egC.setVisibility(8);
            }
            String avatar = eVar.getAvatar();
            bVar.egr.setTag(avatar);
            bVar.egr.c(avatar, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (!this.bgf) {
            return PE();
        }
        int itemViewType = getItemViewType(i);
        View oY = view == null ? oY(itemViewType) : view;
        if (itemViewType == 1) {
            if (oY.getTag() != null && (oY.getTag() instanceof a)) {
                view2 = oY;
                aVar = (a) oY.getTag();
            } else {
                View oY2 = oY(itemViewType);
                view2 = oY2;
                aVar = (a) oY2.getTag();
            }
            this.egk.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
            this.egk.getLayoutMode().x(view2.findViewById(t.g.sign_all_forum_tip));
            aVar.egp.setText(((com.baidu.tieba.signall.b) getItem(i)).getTitle());
            x(aVar.egq, i);
            return view2;
        }
        if (oY.getTag() == null || !(oY.getTag() instanceof b)) {
            oY = oY(itemViewType);
        }
        a(oY, viewGroup, i);
        return oY;
    }

    private void x(TextView textView, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        String format;
        int level = this.efP == null ? 7 : this.efP.getLevel();
        if (this.aZF == null || this.aZF.size() <= 0) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            Iterator<e> it = this.aZF.iterator();
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            while (it.hasNext()) {
                e next = it.next();
                if (!TextUtils.isEmpty(next.getForumName())) {
                    if (next.getUserLevel() >= level) {
                        if (next.aPN()) {
                            i5++;
                        } else {
                            i4++;
                        }
                    } else if (next.aPN()) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (i == 0 && i5 + i4 > 0) {
            format = String.format(this.egk.getPageContext().getString(t.j.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i4));
        } else {
            format = String.format(this.egk.getPageContext().getString(t.j.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i2));
        }
        textView.setText(format);
    }

    private View PE() {
        View inflate = LayoutInflater.from(this.egk.getPageContext().getPageActivity()).inflate(t.h.sign_all_forum_nodata_item, (ViewGroup) null);
        com.baidu.tbadk.core.view.p a2 = NoDataViewFactory.a(this.egk.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(t.g.sign_all_forum_no_data_view), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, 0), NoDataViewFactory.d.v(t.j.sign_all_forum_nodata_tip, t.j.sign_all_forum_nodata_guide), null);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.egk.getLayoutMode().ab(skinType == 1);
        this.egk.getLayoutMode().x(inflate);
        a2.onChangeSkinType(this.egk.getPageContext(), skinType);
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
    /* loaded from: classes.dex */
    public class b {
        public ProgressBar egA;
        public TextView egB;
        public TextView egC;
        public TextView egD;
        public BarImageView egr;
        public LinearLayout egs;
        public TextView egt;
        public ImageView egu;
        public TextView egv;
        public FrameLayout egw;
        public TextView egx;
        public RelativeLayout egy;
        public ImageView egz;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        public TextView egp;
        public TextView egq;

        a() {
        }
    }

    @Override // com.baidu.tieba.signall.ah.a
    public void b(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.egl.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ah.a
    public void onError(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.k.showToast(this.egk.getPageContext().getPageActivity(), str2);
        }
        synchronized (this) {
            this.egl.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.aZF.size();
        for (int i = 0; i < size; i++) {
            e eVar = this.aZF.get(i);
            if (new StringBuilder(String.valueOf(eVar.getForumId())).toString().equals(str)) {
                eVar.iw(z);
                eVar.ix(!z);
                eVar.iy(false);
                if (z) {
                    eVar.oW(signData.getCountSignNum());
                    eVar.oX(signData.getBonusPoint());
                    eVar.oV(1);
                    TbadkApplication.getInst().addSignedForum(eVar.getForumName(), signData.getBonusPoint(), -1);
                    ArrayList<e> aPB = this.efP.aPB();
                    if (aPB.contains(eVar)) {
                        aPB.remove(eVar);
                        this.efP.aPA().add(eVar);
                    }
                } else {
                    eVar.setErrorMsg(str2);
                }
                if (!this.egd) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void aPV() {
        this.egd = true;
        synchronized (this) {
            for (Map.Entry<String, ah> entry : this.egl.entrySet()) {
                entry.getValue().aQp();
            }
            this.egl.clear();
        }
    }
}
