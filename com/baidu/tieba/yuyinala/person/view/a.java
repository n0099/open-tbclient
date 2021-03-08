package com.baidu.tieba.yuyinala.person.view;

import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.ax;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.view.b;
import com.baidu.tieba.yuyinala.person.PersonCardActivity;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private static final int hZg = "   ".length();
    private ax hJu;
    private TextView hZi;
    private TextView hZj;
    private TextView hZk;
    private View hZl;
    private List<AlaLiveMarkData> hZm;
    private List<AlaLiveMarkData> hZn;
    private List<AlaLiveMarkData> hZo;
    private int hZp = 0;
    private long lastClickTime = 0;
    private View mContentView;
    private View mRootView;
    private PersonCardActivity oPi;

    public a(PersonCardActivity personCardActivity, View view, View view2) {
        this.oPi = personCardActivity;
        this.mContentView = view;
        this.mRootView = view2;
        initView();
    }

    private void initView() {
        if (this.mContentView != null) {
            this.hZi = (TextView) this.mContentView.findViewById(a.f.user_mark_normal);
            this.hZj = (TextView) this.mContentView.findViewById(a.f.user_mark_extra);
            this.hZk = (TextView) this.mRootView.findViewById(a.f.user_name);
            this.hZj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.person.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cmS();
                }
            });
            this.hZl = this.mContentView.findViewById(a.f.user_mark_divider);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.yuyinala.person.PersonCardActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void cmS() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime >= 500) {
            this.lastClickTime = currentTimeMillis;
            if (this.hJu != null && com.baidu.live.ae.a.Qm().bCs.aRv != null) {
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(this.hJu.user_id)) {
                    String str = com.baidu.live.ae.a.Qm().bCs.aRv.aRh;
                    if (!TextUtils.isEmpty(str)) {
                        UrlManager.getInstance().dealOneLink(this.oPi.getPageContext(), new String[]{str});
                    }
                } else {
                    String str2 = com.baidu.live.ae.a.Qm().bCs.aRv.aRi;
                    if (str2 != null && this.hJu != null) {
                        if (str2.endsWith("/")) {
                            str2 = str2.substring(0, str2.length() - 1);
                        }
                        String str3 = this.hJu.user_id;
                        String str4 = this.hJu.portrait;
                        String str5 = this.hJu.user_nickname;
                        StringBuilder sb = new StringBuilder();
                        sb.append("id=");
                        sb.append(ExtraParamsManager.getEncryptionUserId(str3));
                        sb.append(ETAG.ITEM_SEPARATOR);
                        sb.append("portrait=");
                        try {
                            sb.append(URLEncoder.encode(str4, "UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        sb.append(ETAG.ITEM_SEPARATOR);
                        sb.append("nickname=");
                        try {
                            sb.append(URLEncoder.encode(str5, "UTF-8"));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                        if (!str2.contains("?")) {
                            sb.insert(0, "?");
                        } else {
                            sb.insert(0, ETAG.ITEM_SEPARATOR);
                        }
                        sb.insert(0, str2);
                        String sb2 = sb.toString();
                        this.oPi.finish();
                        if (!TextUtils.isEmpty(sb2)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913132, sb2));
                        }
                    } else {
                        return;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
            }
        }
    }

    public void setData(ax axVar) {
        if (axVar != null) {
            this.hJu = axVar;
            if (this.hZm == null) {
                this.hZm = new ArrayList();
            }
            this.hZm.clear();
            if (this.hZn == null) {
                this.hZn = new ArrayList();
            }
            this.hZn.clear();
            if (this.hZo == null) {
                this.hZo = new ArrayList();
            }
            this.hZo.clear();
            boolean cJ = cJ(axVar.live_mark_info_new);
            if (!ListUtils.isEmpty(this.hZm)) {
                a("", "", this.hZi, this.hZm);
            }
            if (!ListUtils.isEmpty(this.hZn) || cJ) {
                int i = axVar.aPS;
                if (i <= 0) {
                    i = this.hZp;
                }
                a("  ", i + this.oPi.getResources().getString(a.h.ala_count_mei), this.hZj, this.hZn);
                this.hZj.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_person_card_more, 0);
                this.hZl.setVisibility(0);
            } else {
                this.hZj.setText("");
                this.hZj.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.hZl.setVisibility(8);
            }
            if (!ListUtils.isEmpty(this.hZo)) {
                a(cmT() + " ", "", this.hZk, this.hZo);
            }
        }
    }

    private String cmT() {
        String nameShow = this.hJu.getNameShow();
        if (nameShow != null) {
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                return TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            return nameShow;
        }
        return "";
    }

    private void a(String str, String str2, final TextView textView, List<AlaLiveMarkData> list) {
        if (str == null) {
            str = "";
        }
        int length = str.length();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                str = str + "   ";
            }
        }
        String str3 = str + str2;
        if (list == null || list.isEmpty()) {
            textView.setText(str3);
            return;
        }
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                AlaLiveMarkData alaLiveMarkData = list.get(i3);
                if (this.hJu != null) {
                    alaLiveMarkData.userLevel = this.hJu.level_id;
                    alaLiveMarkData.setupNewLevelMark();
                }
                if (alaLiveMarkData != null) {
                    final int i4 = length + (hZg * i3);
                    final int i5 = i4 + 1;
                    AlaLiveMarkData alaLiveMarkData2 = new AlaLiveMarkData();
                    alaLiveMarkData2.mark_pic = alaLiveMarkData.mark_pic;
                    if (textView.getId() == a.f.user_name) {
                        alaLiveMarkData2.height = this.oPi.getResources().getDimensionPixelSize(a.d.sdk_ds36);
                    }
                    alaLiveMarkData2.isWidthAutoFit = true;
                    new b(this.oPi, alaLiveMarkData2, true, new b.a() { // from class: com.baidu.tieba.yuyinala.person.view.a.2
                        @Override // com.baidu.live.view.b.a
                        public void e(Bitmap bitmap) {
                        }

                        @Override // com.baidu.live.view.b.a
                        public void a(b bVar, Bitmap bitmap) {
                            spannableStringBuilder.setSpan(bVar, i4, i5, 17);
                            textView.setText(spannableStringBuilder);
                        }
                    });
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private boolean cJ(List<AlaLiveMarkData> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        LinkedList<AlaLiveMarkData> linkedList = new LinkedList();
        for (AlaLiveMarkData alaLiveMarkData : list) {
            if (alaLiveMarkData != null && !TextUtils.isEmpty(alaLiveMarkData.mark_pic) && 3 != alaLiveMarkData.type && 4 != alaLiveMarkData.type) {
                if (StringUtils.isNull(alaLiveMarkData.anchor_user_id) || "0".equals(alaLiveMarkData.anchor_user_id)) {
                    linkedList.add(alaLiveMarkData);
                } else if (alaLiveMarkData.anchor_user_id.equals(this.oPi.cmz())) {
                    linkedList.add(alaLiveMarkData);
                }
            }
        }
        if (ListUtils.isEmpty(linkedList)) {
            return false;
        }
        boolean z = false;
        for (AlaLiveMarkData alaLiveMarkData2 : linkedList) {
            if (alaLiveMarkData2.type == 103 || alaLiveMarkData2.type == 104) {
                this.hZn.add(alaLiveMarkData2);
            } else if (alaLiveMarkData2.type == 2) {
                this.hZo.add(alaLiveMarkData2);
            } else {
                this.hZm.add(alaLiveMarkData2);
            }
            z = alaLiveMarkData2.type == 105 ? true : z;
        }
        this.hZp = this.hZn.size();
        if (this.hZp > 2) {
            this.hZn = this.hZn.subList(0, 2);
        }
        if (this.hZm.size() > 3) {
            this.hZm = this.hZm.subList(0, 3);
        }
        return z;
    }
}
