package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.m;
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
public class PostData implements com.baidu.adp.widget.ListView.i, ae {
    private SkinInfo aPD;
    private String aPG;
    private OriginalThreadInfo aQl;
    @Deprecated
    private String authorId;
    private TbRichTextVoiceInfo bdZ;
    private String bimg_url;
    private String fGQ;
    private SmallTailInfo gaN;
    private ArrayList<PostData> haL;
    private com.baidu.tbadk.data.c haS;
    private com.baidu.tbadk.data.f haT;
    private h haW;
    private ay haX;
    public boolean haZ;
    private com.baidu.tbadk.widget.richText.f hba;
    private String hbb;
    private String hbc;
    private TPointPost hbd;
    public int hbh;
    public AlaLiveInfoCoreData hbm;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId haA = BdUniqueId.gen();
    public static final BdUniqueId haB = BdUniqueId.gen();
    public static final BdUniqueId aPE = BdUniqueId.gen();
    public static final BdUniqueId haC = BdUniqueId.gen();
    public static final BdUniqueId aOm = BdUniqueId.gen();
    public static final BdUniqueId haD = BdUniqueId.gen();
    public static final BdUniqueId haE = BdUniqueId.gen();
    public static final BdUniqueId haF = BdUniqueId.gen();
    public static boolean haG = false;
    private int haH = 0;
    private boolean haM = false;
    private ArrayList<PostData> haN = null;
    private TbRichText haO = null;
    private boolean haR = false;
    private boolean haU = false;
    private boolean haV = false;
    public boolean haY = false;
    public int aPd = 0;
    private boolean hbe = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean hbf = false;
    public boolean hbg = false;
    public boolean hbi = false;
    public boolean hbj = true;
    public boolean hbk = false;
    public boolean hbl = false;
    private boolean hbn = false;
    private int hbo = 0;
    private boolean hbp = true;
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData aOF = new MetaData();
    private ArrayList<k> haI = new ArrayList<>();
    private ArrayList<k> haJ = new ArrayList<>();
    private int haK = 0;
    private int aPn = 0;
    private PraiseData aOR = new PraiseData();
    private am haP = new am();
    private c haQ = new c();
    private ArrayList<com.baidu.tbadk.data.c> aPB = new ArrayList<>();

    public PostData() {
        this.haL = null;
        this.hbh = 0;
        this.haL = new ArrayList<>();
        this.hbh = 0;
    }

    public ArrayList<PostData> bwM() {
        return this.haN;
    }

    public void bwN() {
        this.haN.clear();
        this.haN = null;
        this.haM = false;
    }

    public void p(PostData postData) {
        if (postData != null) {
            if (this.haN == null) {
                this.haN = new ArrayList<>();
                if (v.D(this.haL) > 2) {
                    this.haN.addAll(v.b(this.haL, 0, 2));
                } else {
                    this.haN.addAll(this.haL);
                }
            }
            this.haN.add(postData);
        }
    }

    public void q(PostData postData) {
        if (postData != null && this.haL != null) {
            this.haL.add(postData);
            bwR();
        }
    }

    public void sM(String str) {
        if (this.haN != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.haN.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.haN.remove(next);
                    return;
                }
            }
        }
    }

    public void mG(boolean z) {
        this.hbp = z;
    }

    public boolean bwO() {
        return this.hbp;
    }

    public void mH(boolean z) {
        this.haM = z;
    }

    public boolean bwP() {
        return this.haM;
    }

    public ArrayList<PostData> bwQ() {
        return this.haL;
    }

    public void bwR() {
        this.haK++;
    }

    public void bwS() {
        this.haK--;
    }

    public void vL(int i) {
        this.haK = i;
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

    public String bal() {
        return this.fGQ;
    }

    public int bwT() {
        return this.floor_num;
    }

    public void vM(int i) {
        this.floor_num = i;
    }

    public boolean bwU() {
        return this.haV;
    }

    public void mI(boolean z) {
        this.haV = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = com.baidu.tbadk.core.util.am.z(j);
    }

    public String bwV() {
        return this.date;
    }

    public MetaData zn() {
        return this.aOF;
    }

    public void a(MetaData metaData) {
        this.aOF = metaData;
    }

    public void a(PraiseData praiseData) {
        this.aOR = praiseData;
    }

    public TbRichText bwW() {
        return this.haO;
    }

    public void c(TbRichText tbRichText) {
        this.haO = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bgZ() {
        return this.gaN;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.gaN = smallTailInfo;
    }

    public com.baidu.tbadk.data.f bwX() {
        return this.haT;
    }

    public SkinInfo zJ() {
        return this.aPD;
    }

    public void mJ(boolean z) {
        this.hbn = z;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.haO != null && this.haO.Rh() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else if (this.aOF != null && this.aOF.getIs_bawu() == 1 && "manager".equals(this.aOF.getBawu_type())) {
                str = " 吧主";
            } else if (this.aOF == null || this.aOF.getIs_bawu() != 1 || !"assist".equals(this.aOF.getBawu_type())) {
                str = "";
            } else {
                str = " 小吧";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = zn().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.c.nm().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.nm().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str4, int i) {
                                        super.onLoaded((C02371) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.si()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.haO.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.k(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.aOF.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.aOF.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.aOF == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.aOF.getName_show() + str + "：");
                str2 = this.aOF.getUserName();
                str3 = this.aOF.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.aOF.getSealPrefix())) {
                Bitmap fO = aj.fO(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(fO);
                if (fO != null) {
                    bitmapDrawable.setBounds(0, 0, fO.getWidth(), fO.getHeight());
                }
                m mVar = new m(bitmapDrawable);
                mVar.setOffset(com.baidu.adp.lib.util.l.t(tbPageContext.getPageActivity(), d.e.ds2));
                int size = arrayList.size() + this.aOF.getSealPrefix().length() + 1;
                spannableString.setSpan(mVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.aOF != null && this.aOF.getIs_bawu() == 1))) {
                CustomForegroundColorSpan customForegroundColorSpan = new CustomForegroundColorSpan(d.C0141d.cp_link_tip_a);
                if (this.aOF != null) {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length() + this.aOF.getName_show().length() + 1, str.length() + sb2.length() + this.aOF.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(customForegroundColorSpan, sb2.length(), str.length() + sb2.length(), 17);
                }
            }
            ArrayList<TbRichTextData> Rh = this.haO.Rh();
            if (Rh != null && Rh.size() > 0) {
                TbRichTextData tbRichTextData2 = Rh.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.Ro() != null) {
                    if (this.hbn) {
                        int indexOf = tbRichTextData2.Ro().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.Ro().delete(0, indexOf + 1);
                        }
                        this.hbn = false;
                    }
                    tbRichTextData2.iU(sb.length());
                    tbRichTextData2.Ro().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Rh.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (Rh.get(i4) == null || Rh.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        TbRichTextVoiceInfo Rp = Rh.get(i4).Rp();
                        Rh.remove(i4);
                        tbRichTextVoiceInfo = Rp;
                        break;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.iU(sb.length());
                tbRichTextData.append(spannableString);
                Rh.add(0, tbRichTextData);
            }
        }
    }

    protected Drawable h(com.baidu.adp.widget.a.a aVar) {
        Bitmap sh;
        if (aVar == null || (sh = aVar.sh()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(sh);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36));
        return bitmapDrawable;
    }

    public int bwY() {
        return this.haK;
    }

    public void cj(Context context) {
        int type;
        int i;
        int i2;
        if (this.haI != null) {
            int i3 = -1;
            int size = this.haJ.size();
            if (size > 0) {
                try {
                    i3 = this.haJ.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.haI.size()) {
                k kVar = this.haI.get(i4);
                if (k.cH(i5, kVar.getType())) {
                    this.haJ.get(size - 1).b(kVar.ci(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (kVar.getType() == 3 || kVar.getType() == 2 || kVar.getType() == 11) {
                        this.haJ.add(kVar);
                        type = kVar.getType();
                    } else {
                        k kVar2 = new k();
                        kVar2.setType(0);
                        kVar2.b(kVar.ci(context));
                        this.haJ.add(kVar2);
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

    public void ck(Context context) {
        try {
            if (this.haO != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.haO.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.haJ == null || this.haJ.size() == 0) {
                cj(context);
            }
            ArrayList<k> arrayList = this.haJ;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<k> it = arrayList.iterator();
                while (it.hasNext()) {
                    k next = it.next();
                    if (next.getType() == 0) {
                        if (next.bwF() != null) {
                            sb.append((CharSequence) next.bwF());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.j.voice_str));
                    } else if (next.getType() == 2) {
                        String gm = TbFaceManager.Mv().gm(next.getText());
                        if (gm != null) {
                            sb.append("[");
                            sb.append(gm);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !com.baidu.tbadk.core.util.am.isEmpty(next.bwE())) {
                        sb.append("[").append(next.bwE()).append("]");
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
                this.date = com.baidu.tbadk.core.util.am.z(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.haU = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aOF = metaData;
                }
                if ((this.aOF.getUserId() == null || this.aOF.getUserId().length() <= 0 || this.aOF.getUserId().equals("0")) && metaData2 != null) {
                    this.aOF = metaData2;
                }
                this.haO = TbRichTextView.a(context, subPostList.content, z);
                if (this.haO != null) {
                    this.haO.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
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
                this.date = com.baidu.tbadk.core.util.am.z(this.time);
                this.fGQ = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.aOF = metaData;
                }
                this.hbf = post.need_log.intValue() == 1;
                this.hbg = post.img_num_abtest.intValue() == 1;
                this.haX = new ay();
                this.haX.parserProtobuf(post.from_forum);
                if (this.aOF.getUserId() == null || this.aOF.getUserId().length() <= 0 || this.aOF.getUserId().equals("0")) {
                    this.aOF.parserProtobuf(post.author);
                }
                if (this.aOF != null && context != null) {
                    this.hbb = this.aOF.getUserName() + context.getResources().getString(d.j.somebodys_portrait);
                    this.hbc = String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(this.aOF.getLevel_id()));
                }
                this.haR = post.is_ntitle.intValue() == 1;
                this.haK = post.sub_post_number.intValue();
                this.haW = new h(post.tpoint_post);
                this.haO = TbRichTextView.a(context, post.content, true);
                if (this.haO != null) {
                    this.haO.setPostId(com.baidu.adp.lib.g.b.c(this.id, -1L));
                    this.haO.iT(this.floor_num);
                    if (this.aOF != null) {
                        this.haO.setAuthorId(this.aOF.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.haU = subPostList.is_giftpost.intValue() == 1;
                            postData.setUserMap(this.userMap);
                            postData.a(subPostList, context);
                            this.haL.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.haQ.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.haS = new com.baidu.tbadk.data.c();
                    this.haS.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.haT = new com.baidu.tbadk.data.f();
                    this.haT.a(post.lbs_info);
                }
                this.aPn = post.storecount.intValue();
                this.haP.a(post.present);
                this.aOR.setUserMap(this.userMap);
                this.aOR.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.gaN = new SmallTailInfo();
                    this.gaN.id = post.signature.signature_id.intValue();
                    this.gaN.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.gaN.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.gaN.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.gaN.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.aPB.add(cVar);
                    }
                }
                this.aPD = post.skin_info;
                this.aPG = post.lego_card;
                this.hbd = post.tpoint_post;
                if (post.agree != null) {
                    this.hbe = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                } else {
                    this.hbe = false;
                }
                this.hbl = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.aQl = new OriginalThreadInfo();
                    this.aQl.parser(post.origin_thread_info);
                } else {
                    this.aQl = null;
                }
                this.hbo = post.is_fold.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int fZd;

        public CustomForegroundColorSpan(int i) {
            super(aj.getColor(i));
            this.fZd = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(this.fZd));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> hbv;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.hbv = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(d.C0141d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.hbv != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.hbv.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String cl(Context context) {
        ArrayList<TbRichTextData> Rh;
        if (this.haO == null || (Rh = this.haO.Rh()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = Rh.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Ro().toString());
            } else if (next.getType() == 17) {
                String str = next.Rs().mGifInfo.mSharpText;
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

    public String bwZ() {
        ArrayList<TbRichTextData> Rh;
        String str;
        if (this.haO == null || (Rh = this.haO.Rh()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = Rh.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.Ro().toString());
                } else if (next.getType() == 17) {
                    if (next.Rs() != null && next.Rs().mGifInfo != null && (str = next.Rs().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo bxa() {
        ArrayList<TbRichTextData> Rh;
        if (this.haO != null && (Rh = this.haO.Rh()) != null) {
            Iterator<TbRichTextData> it = Rh.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.Rn().getWidth();
                    preLoadImageInfo.height = next.Rn().getHeight();
                    preLoadImageInfo.imgUrl = next.Rn().RB();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.Rt().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.Rt().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.Rt().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String bxb() {
        j bwx;
        PreLoadImageInfo bxa = bxa();
        if (bxa != null && !StringUtils.isNull(bxa.imgUrl)) {
            return bxa.imgUrl;
        }
        if (this.haW != null && (bwx = this.haW.bwx()) != null && !StringUtils.isNull(bwx.bwC())) {
            return bwx.bwC();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> Rh;
        if (this.haO == null || (Rh = this.haO.Rh()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = Rh.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.Rn().getWidth();
                preLoadImageInfo.height = next.Rn().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.Rn().RG()) {
                    preLoadImageInfo.imgUrl = next.Rn().RC();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.Rn().RB();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.Rs() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.Rs().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.Rs().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.Rs();
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
        if (this.aOF == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.aOF.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.haH == 52) {
            return haE;
        }
        if (this.haH == 1) {
            return aPE;
        }
        if (this.haH == 36) {
            return haC;
        }
        if (this.haH == 40 || this.haH == 50) {
            return aOm;
        }
        if (this.haH == 41) {
            return haD;
        }
        if (this.haH == 53) {
            return haF;
        }
        if (bwT() == 1) {
            return haA;
        }
        return haB;
    }

    public void setPostType(int i) {
        this.haH = i;
    }

    public am bxc() {
        return this.haP;
    }

    public void a(am amVar) {
        this.haP = amVar;
    }

    public h bxd() {
        return this.haW;
    }

    public com.baidu.tbadk.widget.richText.f Rr() {
        if (this.hba != null) {
            return this.hba;
        }
        if (this.haO != null && v.D(this.haO.Rh()) > 0) {
            Iterator<TbRichTextData> it = this.haO.Rh().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.hba = next.Rr();
                    return this.hba;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo Rp() {
        if (this.bdZ != null) {
            return this.bdZ;
        }
        if (this.haO != null && v.D(this.haO.Rh()) > 0) {
            Iterator<TbRichTextData> it = this.haO.Rh().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.bdZ = next.Rp();
                    return this.bdZ;
                }
            }
        }
        return null;
    }

    public String bxe() {
        return this.hbb;
    }

    public String Af() {
        return this.aPG;
    }

    public void Ai() {
        if (this.aPd == 0) {
            this.aPd = 1;
        }
    }

    public long bxf() {
        return this.agreeNum;
    }

    public void cQ(long j) {
        this.agreeNum = j;
    }

    public boolean bxg() {
        return this.hasAgree;
    }

    public void mK(boolean z) {
        this.hasAgree = z;
    }

    public OriginalThreadInfo bxh() {
        return this.aQl;
    }

    public void f(OriginalThreadInfo originalThreadInfo) {
        this.aQl = originalThreadInfo;
    }

    public int bxi() {
        return this.hbo;
    }
}
