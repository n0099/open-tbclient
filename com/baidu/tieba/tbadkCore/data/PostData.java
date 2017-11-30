package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.c;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.d;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements com.baidu.adp.widget.ListView.f, ae {
    private SkinInfo ZY;
    private OriginalThreadInfo aaI;
    private String aab;
    private TbRichTextVoiceInfo aok;
    @Deprecated
    private String authorId;
    private String bimg_url;
    private String eNZ;
    private SmallTailInfo fhU;
    private h gzC;
    private ay gzD;
    public boolean gzF;
    private com.baidu.tbadk.widget.richText.f gzG;
    private String gzH;
    private String gzI;
    private TPointPost gzJ;
    public int gzN;
    public AlaLiveInfoCoreData gzR;
    private boolean gzT;
    private ArrayList<PostData> gzr;
    private com.baidu.tbadk.data.a gzy;
    private com.baidu.tbadk.data.i gzz;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId gze = BdUniqueId.gen();
    public static final BdUniqueId gzf = BdUniqueId.gen();
    public static final BdUniqueId gzg = BdUniqueId.gen();
    public static final BdUniqueId ZZ = BdUniqueId.gen();
    public static final BdUniqueId gzh = BdUniqueId.gen();
    public static final BdUniqueId YJ = BdUniqueId.gen();
    public static final BdUniqueId gzi = BdUniqueId.gen();
    public static final BdUniqueId gzj = BdUniqueId.gen();
    public static final BdUniqueId gzk = BdUniqueId.gen();
    public static final BdUniqueId gzl = BdUniqueId.gen();
    public static boolean gzm = false;
    private int gzn = 0;
    private boolean gzs = false;
    private ArrayList<PostData> gzt = null;
    private TbRichText gzu = null;
    private boolean gzx = false;
    private boolean gzA = false;
    private boolean gzB = false;
    public boolean gzE = false;
    public int ZA = 0;
    private boolean gzK = false;
    private long cLx = 0;
    private boolean cLz = false;
    public boolean gzL = false;
    public boolean gzM = false;
    public boolean gzO = false;
    public boolean gzP = true;
    public boolean cSS = false;
    public boolean gzQ = false;
    private boolean gzS = false;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData Zc = new MetaData();
    private ArrayList<k> gzo = new ArrayList<>();
    private ArrayList<k> gzp = new ArrayList<>();
    private int gzq = 0;
    private int ZK = 0;
    private PraiseData Zo = new PraiseData();
    private am gzv = new am();
    private c gzw = new c();
    private ArrayList<com.baidu.tbadk.data.a> ZW = new ArrayList<>();

    public PostData() {
        this.gzr = null;
        this.gzN = 0;
        this.gzr = new ArrayList<>();
        this.gzN = 0;
    }

    public ArrayList<PostData> bwh() {
        return this.gzt;
    }

    public void bwi() {
        this.gzt.clear();
        this.gzt = null;
        this.gzs = false;
    }

    public void z(PostData postData) {
        if (postData != null) {
            if (this.gzt == null) {
                this.gzt = new ArrayList<>();
                if (v.v(this.gzr) > 2) {
                    this.gzt.addAll(v.a(this.gzr, 0, 2));
                } else {
                    this.gzt.addAll(this.gzr);
                }
            }
            this.gzt.add(postData);
        }
    }

    public void A(PostData postData) {
        if (postData != null && this.gzr != null) {
            this.gzr.add(postData);
            bwm();
        }
    }

    public void sZ(String str) {
        if (this.gzt != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.gzt.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.gzt.remove(next);
                    return;
                }
            }
        }
    }

    public void mZ(boolean z) {
        this.gzs = z;
    }

    public boolean bwj() {
        return this.gzs;
    }

    public c bwk() {
        return this.gzw;
    }

    public ArrayList<PostData> bwl() {
        return this.gzr;
    }

    public void bwm() {
        this.gzq++;
    }

    public void bwn() {
        this.gzq--;
    }

    public void uk(int i) {
        this.gzq = i;
    }

    public boolean isGiftPost() {
        return this.gzA;
    }

    public void setIsGiftPost(boolean z) {
        this.gzA = z;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String aQU() {
        return this.eNZ;
    }

    public int bwo() {
        return this.floor_num;
    }

    public void ul(int i) {
        this.floor_num = i;
    }

    public boolean bwp() {
        return this.gzB;
    }

    public void na(boolean z) {
        this.gzB = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = com.baidu.tbadk.core.util.am.r(j);
    }

    public String bwq() {
        return this.date;
    }

    public MetaData rx() {
        return this.Zc;
    }

    public void a(MetaData metaData) {
        this.Zc = metaData;
    }

    public void a(PraiseData praiseData) {
        this.Zo = praiseData;
    }

    public TbRichText bwr() {
        return this.gzu;
    }

    public void d(TbRichText tbRichText) {
        this.gzu = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo aXW() {
        return this.fhU;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.fhU = smallTailInfo;
    }

    public com.baidu.tbadk.data.i bws() {
        return this.gzz;
    }

    public SkinInfo rT() {
        return this.ZY;
    }

    public void nb(boolean z) {
        this.gzS = z;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.gzu != null && this.gzu.Jq() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else if (this.Zc != null && this.Zc.getIs_bawu() == 1 && "manager".equals(this.Zc.getBawu_type())) {
                str = " 吧主";
            } else if (this.Zc == null || this.Zc.getIs_bawu() != 1 || !"assist".equals(this.Zc.getBawu_type())) {
                str = "";
            } else {
                str = " 小吧";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = rx().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.fJ().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.fJ().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str4, int i) {
                                        super.onLoaded((C01291) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.kL()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.gzu.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.c(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.Zc.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.Zc.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.Zc == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.Zc.getName_show() + str + "：");
                str2 = this.Zc.getUserName();
                str3 = this.Zc.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.Zc.getSealPrefix())) {
                Bitmap cR = aj.cR(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
                if (cR != null) {
                    bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds2));
                int size = arrayList.size() + this.Zc.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.Zc != null && this.Zc.getIs_bawu() == 1))) {
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.C0082d.cp_link_tip_a);
                if (this.Zc != null) {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length() + this.Zc.getName_show().length() + 1, str.length() + sb2.length() + this.Zc.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length(), str.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> Jq = this.gzu.Jq();
            if (Jq != null && Jq.size() > 0) {
                TbRichTextData tbRichTextData2 = Jq.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.Jx() != null) {
                    if (this.gzS) {
                        int indexOf = tbRichTextData2.Jx().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.Jx().delete(0, indexOf + 1);
                        }
                        this.gzS = false;
                    }
                    tbRichTextData2.gc(sb.length());
                    tbRichTextData2.Jx().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Jq.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (Jq.get(i4) == null || Jq.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo Jy = Jq.get(i4).Jy();
                        Jq.remove(i4);
                        tbRichTextVoiceInfo = Jy;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.gc(sb.length());
                tbRichTextData.append(spannableString);
                Jq.add(0, tbRichTextData);
            }
        }
    }

    public void c(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        TbRichTextData tbRichTextData;
        TbRichTextVoiceInfo tbRichTextVoiceInfo = null;
        if (tbPageContext != null && this.gzu != null && this.gzu.Jq() != null) {
            String str3 = z ? " 楼主" : "";
            String sb = new StringBuilder().toString();
            String name_show = this.Zc.getName_show();
            if (com.baidu.adp.lib.util.k.aP(this.Zc.getName_show()) > 14) {
                name_show = com.baidu.tbadk.core.util.am.e(this.Zc.getName_show(), 14, "...");
            }
            if (this.Zc != null) {
                spannableString = new SpannableString(sb + name_show + str3 + "：");
                str = this.Zc.getUserName();
                str2 = this.Zc.getUserId();
            } else {
                str = null;
                spannableString = new SpannableString(sb + str3 + "：");
                str2 = null;
            }
            if (!StringUtils.isNull(this.Zc.getSealPrefix())) {
                Bitmap cR = aj.cR(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
                if (cR != null) {
                    bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
                }
                com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                iVar.setOffset(com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds2));
                int length = this.Zc.getSealPrefix().length() + 1;
                spannableString.setSpan(iVar, length, length + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str, str2), 0, spannableString.length(), 18);
            if (z) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.f(tbPageContext.getPageActivity(), d.e.ds28));
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.C0082d.cp_link_tip_a);
                if (this.Zc != null) {
                    spannableString.setSpan(absoluteSizeSpan, sb.length() + this.Zc.getName_show().length() + 1, sb.length() + this.Zc.getName_show().length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb.length() + this.Zc.getName_show().length() + 1, str3.length() + sb.length() + this.Zc.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(absoluteSizeSpan, sb.length(), sb.length() + str3.length(), 17);
                    spannableString.setSpan(customForegroundColorSpan, sb.length(), str3.length() + sb.length(), 17);
                }
            }
            ArrayList<TbRichTextData> Jq = this.gzu.Jq();
            if (Jq != null && Jq.size() > 0) {
                TbRichTextData tbRichTextData2 = Jq.get(0);
                if (tbRichTextData2.Jx() != null) {
                    tbRichTextData2.Jx().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i = 0;
                while (true) {
                    if (i < Jq.size()) {
                        if (Jq.get(i) == null || Jq.get(i).getType() != 512) {
                            i++;
                        } else {
                            tbRichTextVoiceInfo = Jq.get(i).Jy();
                            Jq.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.append(spannableString);
                Jq.add(0, tbRichTextData);
            }
        }
    }

    protected Drawable h(com.baidu.adp.widget.a.a aVar) {
        Bitmap kK;
        if (aVar == null || (kK = aVar.kK()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(kK);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36));
        return bitmapDrawable;
    }

    public int bwt() {
        return this.gzq;
    }

    public void cd(Context context) {
        int type;
        int i;
        int i2;
        if (this.gzo != null) {
            int i3 = -1;
            int size = this.gzp.size();
            if (size > 0) {
                try {
                    i3 = this.gzp.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.gzo.size()) {
                k kVar = this.gzo.get(i4);
                if (k.bV(i5, kVar.getType())) {
                    this.gzp.get(size - 1).b(kVar.cc(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.gzp.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.cc(context));
                        this.gzp.add(kVar2);
                        type = 0;
                    }
                    i = type;
                    i2 = size + 1;
                }
                i4++;
                i5 = i;
                size = i2;
            }
        }
    }

    public void ce(Context context) {
        try {
            if (this.gzu != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.gzu.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.gzp == null || this.gzp.size() == 0) {
                cd(context);
            }
            ArrayList<k> arrayList = this.gzp;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bwa() != null) {
                            sb.append((CharSequence) next.bwa());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.j.voice_str));
                    } else if (next.getType() == 2) {
                        String fO = TbFaceManager.Ey().fO(next.getText());
                        if (fO != null) {
                            sb.append("[");
                            sb.append(fO);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !com.baidu.tbadk.core.util.am.isEmpty(next.bvZ())) {
                        sb.append("[").append(next.bvZ()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                if (clipboardManager2.getText() != null) {
                }
            }
        } catch (NullPointerException e) {
            BdLog.detailException(e);
        }
    }

    public void a(SubPostList subPostList, Context context) {
        a(subPostList, context, false);
    }

    public void a(SubPostList subPostList, Context context, boolean z) {
        MetaData metaData;
        if (subPostList != null) {
            try {
                this.id = String.valueOf(subPostList.id);
                this.title = subPostList.title;
                this.floor_num = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = com.baidu.tbadk.core.util.am.r(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.gzA = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.Zc = metaData;
                }
                if ((this.Zc.getUserId() == null || this.Zc.getUserId().length() <= 0 || this.Zc.getUserId().equals("0")) && metaData2 != null) {
                    this.Zc = metaData2;
                }
                this.gzu = TbRichTextView.a(context, subPostList.content, z);
                if (this.gzu != null) {
                    this.gzu.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        MetaData metaData;
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = com.baidu.tbadk.core.util.am.r(this.time);
                this.eNZ = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.Zc = metaData;
                }
                this.gzL = post.need_log.intValue() == 1;
                this.gzM = post.img_num_abtest.intValue() == 1;
                this.gzD = new ay();
                this.gzD.parserProtobuf(post.from_forum);
                if (this.Zc.getUserId() == null || this.Zc.getUserId().length() <= 0 || this.Zc.getUserId().equals("0")) {
                    this.Zc.parserProtobuf(post.author);
                }
                if (this.Zc != null && context != null) {
                    this.gzH = this.Zc.getUserName() + context.getResources().getString(d.j.somebodys_portrait);
                    this.gzI = String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(this.Zc.getLevel_id()));
                }
                this.gzx = post.is_ntitle.intValue() == 1;
                this.gzq = post.sub_post_number.intValue();
                this.gzC = new h(post.tpoint_post);
                this.gzu = TbRichTextView.a(context, post.content, true);
                if (this.gzu != null) {
                    this.gzu.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.gzu.gb(this.floor_num);
                    if (this.Zc != null) {
                        this.gzu.setAuthorId(this.Zc.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.gzA = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.gzr.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.gzw.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.gzy = new com.baidu.tbadk.data.a();
                    this.gzy.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.gzz = new com.baidu.tbadk.data.i();
                    this.gzz.a(post.lbs_info);
                }
                this.ZK = post.storecount.intValue();
                this.gzv.a(post.present);
                this.Zo.setUserMap(this.userMap);
                this.Zo.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.fhU = new SmallTailInfo();
                    this.fhU.id = post.signature.signature_id.intValue();
                    this.fhU.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.fhU.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.fhU.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.fhU.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.a aVar = new com.baidu.tbadk.data.a();
                        aVar.a(post.ext_tails.get(i2));
                        this.ZW.add(aVar);
                    }
                }
                this.ZY = post.skin_info;
                this.aab = post.lego_card;
                this.gzJ = post.tpoint_post;
                if (post.agree != null) {
                    this.gzK = true;
                    this.cLz = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.cLx = post.agree.agree_num.longValue();
                    } else {
                        this.cLx = 0L;
                    }
                } else {
                    this.gzK = false;
                }
                this.gzQ = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.aaI = new OriginalThreadInfo();
                    this.aaI.parser(post.origin_thread_info);
                } else {
                    this.aaI = null;
                }
                this.gzT = post.is_fold.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int fgi;

        public CustomForegroundColorSpan(int i) {
            super(aj.getColor(i));
            this.fgi = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(this.fgi));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> gzZ;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.gzZ = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(d.C0082d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.gzZ != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.gzZ.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String cf(Context context) {
        ArrayList<TbRichTextData> Jq;
        if (this.gzu == null || (Jq = this.gzu.Jq()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = Jq.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Jx().toString());
            } else if (next.getType() == 17) {
                String str = next.JB().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(d.j.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(d.j.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(d.j.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public PreLoadImageInfo bwu() {
        ArrayList<TbRichTextData> Jq;
        if (this.gzu != null && (Jq = this.gzu.Jq()) != null) {
            Iterator<TbRichTextData> it = Jq.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.Jw().getWidth();
                    preLoadImageInfo.height = next.Jw().getHeight();
                    preLoadImageInfo.imgUrl = next.Jw().JK();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                }
            }
            return null;
        }
        return null;
    }

    public String bwv() {
        j bvS;
        PreLoadImageInfo bwu = bwu();
        if (bwu != null && !StringUtils.isNull(bwu.imgUrl)) {
            return bwu.imgUrl;
        }
        if (this.gzC != null && (bvS = this.gzC.bvS()) != null && !StringUtils.isNull(bvS.bvX())) {
            return bvS.bvX();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Jq;
        if (this.gzu == null || (Jq = this.gzu.Jq()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = Jq.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.Jw().getWidth();
                preLoadImageInfo.height = next.Jw().getHeight();
                preLoadImageInfo.imgUrl = next.Jw().JK();
                preLoadImageInfo.procType = 17;
                arrayList.add(preLoadImageInfo);
            } else if (next.JB() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.JB().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.JB().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.JB();
                preLoadImageInfo2.procType = 20;
                arrayList.add(preLoadImageInfo2);
            }
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.bimg_url;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.procType = 19;
            arrayList.add(preLoadImageInfo3);
        }
        if (this.Zc == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.Zc.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.gzn == 52) {
            return gzk;
        }
        if (this.gzn == 2) {
            return gzg;
        }
        if (this.gzn == 1) {
            return ZZ;
        }
        if (this.gzn == 36) {
            return gzh;
        }
        if (this.gzn == 40 || this.gzn == 50) {
            return YJ;
        }
        if (this.gzn == 41) {
            return gzi;
        }
        if (this.gzn == 53) {
            return gzl;
        }
        if (bwo() == 1) {
            return gze;
        }
        return gzf;
    }

    public void setPostType(int i) {
        this.gzn = i;
    }

    public am bww() {
        return this.gzv;
    }

    public void a(am amVar) {
        this.gzv = amVar;
    }

    public h bwx() {
        return this.gzC;
    }

    public com.baidu.tbadk.widget.richText.f JA() {
        if (this.gzG != null) {
            return this.gzG;
        }
        if (this.gzu != null && v.v(this.gzu.Jq()) > 0) {
            Iterator<TbRichTextData> it = this.gzu.Jq().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.gzG = next.JA();
                    return this.gzG;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo Jy() {
        if (this.aok != null) {
            return this.aok;
        }
        if (this.gzu != null && v.v(this.gzu.Jq()) > 0) {
            Iterator<TbRichTextData> it = this.gzu.Jq().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.aok = next.Jy();
                    return this.aok;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.a> bwy() {
        return this.ZW;
    }

    public String bwz() {
        return this.gzH;
    }

    public String bwA() {
        return this.gzI;
    }

    public String st() {
        return this.aab;
    }

    public void sw() {
        if (this.ZA == 0) {
            this.ZA = 1;
        }
    }

    public long bwB() {
        return this.cLx;
    }

    public void cW(long j) {
        this.cLx = j;
    }

    public boolean bwC() {
        return this.cLz;
    }

    public void nc(boolean z) {
        this.cLz = z;
    }

    public OriginalThreadInfo bwD() {
        return this.aaI;
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        this.aaI = originalThreadInfo;
    }

    public boolean bwE() {
        return this.gzT;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PostData)) {
            return false;
        }
        return (((PostData) obj).getId() == null || getId() == null || !getId().equals(((PostData) obj).getId())) ? false : true;
    }

    public int hashCode() {
        return getId() != null ? getId().hashCode() : "".hashCode();
    }
}
