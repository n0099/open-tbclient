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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
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
import tbclient.Agree;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes.dex */
public class PostData implements com.baidu.adp.widget.ListView.m, ae {
    private Agree agree;
    @Deprecated
    private String authorId;
    private SkinInfo bCK;
    private String bCN;
    private long bDn;
    private int bDp;
    private OriginalThreadInfo bDy;
    private TbRichTextVoiceInfo bTp;
    private String bimg_url;
    private SmallTailInfo hDa;
    private String hjA;
    private String hkk;
    private ArrayList<PostData> iFX;
    private boolean iGB;
    private boolean iGE;
    public am iGG;
    private com.baidu.tbadk.data.c iGe;
    private com.baidu.tbadk.data.f iGf;
    private i iGi;
    private bc iGj;
    public boolean iGl;
    private com.baidu.tbadk.widget.richText.f iGm;
    private String iGn;
    private String iGo;
    private TPointPost iGp;
    public int iGs;
    public AlaLiveInfoCoreData iGx;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId iFL = BdUniqueId.gen();
    public static final BdUniqueId iFM = BdUniqueId.gen();
    public static final BdUniqueId bCL = BdUniqueId.gen();
    public static final BdUniqueId iFN = BdUniqueId.gen();
    public static final BdUniqueId bBg = BdUniqueId.gen();
    public static final BdUniqueId iFO = BdUniqueId.gen();
    public static final BdUniqueId iFP = BdUniqueId.gen();
    public static final BdUniqueId iFQ = BdUniqueId.gen();
    public static final BdUniqueId iFR = BdUniqueId.gen();
    public static boolean iFS = false;
    private int iFT = 0;
    private boolean iFY = false;
    private ArrayList<PostData> iFZ = null;
    private TbRichText iGa = null;
    private boolean iGd = false;
    private boolean iGg = false;
    private boolean iGh = false;
    public boolean iGk = false;
    public int bCj = 0;
    private boolean iGq = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean ffX = false;
    public boolean iGr = false;
    public boolean iGt = false;
    public boolean iGu = true;
    public boolean iGv = false;
    public boolean iGw = false;
    private boolean iGy = false;
    private int iGz = 0;
    private boolean iGA = true;
    public boolean iGC = false;
    public boolean iGD = false;
    public boolean iGF = false;
    private b iGH = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.iGG != null) {
                am adg = PostData.this.iGG.adg();
                adg.delete("obj_locate");
                adg.T("obj_locate", 7);
                TiebaStatic.log(adg);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int floor_num = 0;
    private long time = 0;
    private String date = null;
    private MetaData bBJ = new MetaData();
    private ArrayList<l> iFU = new ArrayList<>();
    private ArrayList<l> iFV = new ArrayList<>();
    private int iFW = 0;
    private int bCu = 0;
    private PraiseData bBW = new PraiseData();
    private ao iGb = new ao();
    private c iGc = new c();
    private ArrayList<com.baidu.tbadk.data.c> bCH = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.iFX = null;
        this.iGs = 0;
        this.iFX = new ArrayList<>();
        this.iGs = 0;
    }

    public void pU(boolean z) {
        this.iGB = z;
    }

    public boolean ceh() {
        return this.iGB;
    }

    public ArrayList<PostData> cei() {
        return this.iFZ;
    }

    public void cej() {
        this.iFZ.clear();
        this.iFZ = null;
        this.iFY = false;
    }

    public void r(PostData postData) {
        if (postData != null) {
            if (this.iFZ == null) {
                this.iFZ = new ArrayList<>();
                if (v.S(this.iFX) > 2) {
                    this.iFZ.addAll(v.c(this.iFX, 0, 2));
                } else {
                    this.iFZ.addAll(this.iFX);
                }
            }
            this.iFZ.add(postData);
        }
    }

    public void s(PostData postData) {
        if (postData != null && this.iFX != null) {
            this.iFX.add(postData);
            cen();
        }
    }

    public void Cy(String str) {
        if (this.iFZ != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.iFZ.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.iFZ.remove(next);
                    return;
                }
            }
        }
    }

    public void pV(boolean z) {
        this.iGA = z;
    }

    public boolean cek() {
        return this.iGA;
    }

    public void pW(boolean z) {
        this.iFY = z;
    }

    public boolean cel() {
        return this.iFY;
    }

    public ArrayList<PostData> cem() {
        return this.iFX;
    }

    public void cen() {
        this.iFW++;
    }

    public void ceo() {
        this.iFW--;
    }

    public void zp(int i) {
        this.iFW = i;
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

    public long getTid() {
        return this.tid;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String bHQ() {
        return this.hjA;
    }

    public int cep() {
        return this.floor_num;
    }

    public void zq(int i) {
        this.floor_num = i;
    }

    public boolean ceq() {
        return this.iGh;
    }

    public void pX(boolean z) {
        this.iGh = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ap.ao(j);
    }

    public MetaData YO() {
        return this.bBJ;
    }

    public void a(MetaData metaData) {
        this.bBJ = metaData;
    }

    public void a(PraiseData praiseData) {
        this.bBW = praiseData;
    }

    public TbRichText cer() {
        return this.iGa;
    }

    public void c(TbRichText tbRichText) {
        this.iGa = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bOL() {
        return this.hDa;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.hDa = smallTailInfo;
    }

    public com.baidu.tbadk.data.f ces() {
        return this.iGf;
    }

    public SkinInfo Zj() {
        return this.bCK;
    }

    public void pY(boolean z) {
        this.iGy = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.iGa != null && this.iGa.ast() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.bBJ != null && this.bBJ.getIs_bawu() == 1) {
                    if (this.iGB) {
                        str = " 品牌官";
                    } else if ("manager".equals(this.bBJ.getBawu_type())) {
                        str = " 吧主";
                    } else if ("assist".equals(this.bBJ.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.bBJ.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.bBJ.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = YO().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.jB().a(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.jB().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.oz()) {
                                            cVar2.setDrawable(PostData.this.h(aVar2));
                                            PostData.this.iGa.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.h(aVar);
                        }
                    }, 0, 1);
                    cVar.d(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(d.e.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.bBJ.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.bBJ.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.bBJ == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.bBJ.getName_show() + str + "：");
                str2 = this.bBJ.getUserName();
                str3 = this.bBJ.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.bBJ.getSealPrefix())) {
                Bitmap hp = al.hp(d.f.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(hp);
                if (hp != null) {
                    bitmapDrawable.setBounds(0, 0, hp.getWidth(), hp.getHeight());
                }
                com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                kVar.setOffset(com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.ds2));
                int size = arrayList.size() + this.bBJ.getSealPrefix().length() + 1;
                spannableString.setSpan(kVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.iGH), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.bBJ != null && this.bBJ.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.c ai = ai(z, this.bBJ != null && this.bBJ.getIs_bawu() == 1);
                if (ai != null) {
                    if (this.bBJ != null) {
                        int i3 = 0;
                        if (this.bBJ.getName_show() != null) {
                            i3 = this.bBJ.getName_show().length();
                        }
                        spannableString.setSpan(ai, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(ai, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> ast = this.iGa.ast();
            if (ast != null && ast.size() > 0) {
                TbRichTextData tbRichTextData2 = ast.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.asB() != null) {
                    if (this.iGy) {
                        int indexOf = tbRichTextData2.asB().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.asB().delete(0, indexOf + 1);
                        }
                        this.iGy = false;
                    }
                    tbRichTextData2.kJ(sb.length());
                    tbRichTextData2.asB().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= ast.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (ast.get(i5) == null || ast.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo asC = ast.get(i5).asC();
                            ast.remove(i5);
                            tbRichTextVoiceInfo = asC;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.kJ(sb.length());
                    tbRichTextData.append(spannableString);
                    ast.add(0, tbRichTextData);
                }
            }
            this.iGC = true;
        }
    }

    private com.baidu.tbadk.core.view.c ai(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c(com.baidu.adp.lib.util.l.h(context, d.e.tbds1), com.baidu.adp.lib.util.l.h(context, d.e.tbds5), this.iGB ? d.C0277d.cp_link_tip_a_alpha50 : d.C0277d.cp_link_tip_a, com.baidu.adp.lib.util.l.h(context, d.e.tbds26), this.iGB ? d.C0277d.cp_link_tip_a : d.C0277d.cp_bg_line_d, com.baidu.adp.lib.util.l.h(context, d.e.tbds12), com.baidu.adp.lib.util.l.h(context, d.e.tbds40));
        if (this.iGB) {
            cVar.dL(false);
            return cVar;
        }
        cVar.dL(true);
        return cVar;
    }

    protected Drawable h(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap oy;
        if (aVar == null || (oy = aVar.oy()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(oy);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(d.e.ds36));
        return bitmapDrawable;
    }

    public int cet() {
        return this.iFW;
    }

    public void et(Context context) {
        int type;
        int i;
        int i2;
        if (this.iFU != null) {
            int i3 = -1;
            int size = this.iFV.size();
            if (size > 0) {
                try {
                    i3 = this.iFV.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.iFU.size()) {
                l lVar = this.iFU.get(i4);
                if (l.co(i5, lVar.getType())) {
                    this.iFV.get(size - 1).b(lVar.es(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.iFV.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.es(context));
                        this.iFV.add(lVar2);
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

    public void eu(Context context) {
        try {
            if (this.iGa != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.iGa.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.iFV == null || this.iFV.size() == 0) {
                et(context);
            }
            ArrayList<l> arrayList = this.iFV;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.cea() != null) {
                            sb.append((CharSequence) next.cea());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(d.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(d.j.voice_str));
                    } else if (next.getType() == 2) {
                        String oJ = TbFaceManager.anl().oJ(next.getText());
                        if (oJ != null) {
                            sb.append("[");
                            sb.append(oJ);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ap.isEmpty(next.cdZ())) {
                        sb.append("[").append(next.cdZ()).append("]");
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
                this.date = ap.ao(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.iGg = subPostList.is_giftpost.intValue() == 1;
                this.agree = subPostList.agree;
                if (this.agree != null) {
                    this.bDp = this.agree.agree_type.intValue();
                    this.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeNum = this.agree.agree_num.longValue() > 0 ? this.agree.agree_num.longValue() : 0L;
                    this.bDn = this.agree.disagree_num.longValue() > 0 ? this.agree.disagree_num.longValue() : 0L;
                    this.agreeData.postId = this.id;
                    this.agreeData.agreeNum = this.agree.agree_num.longValue();
                    this.agreeData.disAgreeNum = this.agree.disagree_num.longValue();
                    this.agreeData.agreeType = this.agree.agree_type == null ? 0 : this.agree.agree_type.intValue();
                    this.agreeData.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeData.diffAgreeNum = this.agree.diff_agree_num != null ? this.agree.diff_agree_num.longValue() : 0L;
                }
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.bBJ = metaData;
                }
                if ((this.bBJ.getUserId() == null || this.bBJ.getUserId().length() <= 0 || this.bBJ.getUserId().equals("0")) && metaData2 != null) {
                    this.bBJ = metaData2;
                }
                this.iGa = TbRichTextView.a(context, subPostList.content, z);
                if (this.iGa != null) {
                    this.iGa.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
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
                this.tid = post.tid.longValue();
                this.title = post.title;
                this.floor_num = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = ap.ao(this.time);
                this.hjA = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.bBJ = metaData;
                }
                this.ffX = post.need_log.intValue() == 1;
                this.iGr = post.img_num_abtest.intValue() == 1;
                this.iGj = new bc();
                this.iGj.parserProtobuf(post.from_forum);
                if (this.bBJ.getUserId() == null || this.bBJ.getUserId().length() <= 0 || this.bBJ.getUserId().equals("0")) {
                    this.bBJ.parserProtobuf(post.author);
                }
                if (this.bBJ != null && context != null) {
                    this.iGn = this.bBJ.getUserName() + context.getResources().getString(d.j.somebodys_portrait);
                    this.iGo = String.format(TbadkCoreApplication.getInst().getString(d.j.degree_in_forum), Integer.valueOf(this.bBJ.getLevel_id()));
                }
                this.iGd = post.is_ntitle.intValue() == 1;
                this.iFW = post.sub_post_number.intValue();
                this.iGi = new i(post.tpoint_post);
                this.iGa = TbRichTextView.a(context, post.content, true);
                if (this.iGa != null) {
                    this.iGa.setPostId(com.baidu.adp.lib.g.b.d(this.id, -1L));
                    this.iGa.kI(this.floor_num);
                    if (this.bBJ != null) {
                        this.iGa.setAuthorId(this.bBJ.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.iGg = subPostList.is_giftpost.intValue() == 1;
                            postData.agree = subPostList.agree;
                            postData.setUserMap(this.userMap);
                            postData.pU(this.iGB);
                            postData.a(subPostList, context);
                            this.iFX.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.iGc.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.iGe = new com.baidu.tbadk.data.c();
                    this.iGe.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.iGf = new com.baidu.tbadk.data.f();
                    this.iGf.a(post.lbs_info);
                }
                this.bCu = post.storecount.intValue();
                this.iGb.a(post.present);
                this.bBW.setUserMap(this.userMap);
                this.bBW.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.hDa = new SmallTailInfo();
                    this.hDa.id = post.signature.signature_id.intValue();
                    this.hDa.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.hDa.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.hDa.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.hDa.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.bCH.add(cVar);
                    }
                }
                this.bCK = post.skin_info;
                this.bCN = post.lego_card;
                this.iGp = post.tpoint_post;
                if (post.agree != null) {
                    this.iGq = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                    if (post.agree.disagree_num.longValue() >= 0) {
                        this.bDn = post.agree.disagree_num.longValue();
                    } else {
                        this.bDn = 0L;
                    }
                    this.bDp = post.agree.agree_type.intValue();
                    this.agreeData.postId = this.id;
                    this.agreeData.agreeType = post.agree.agree_type == null ? 0 : post.agree.agree_type.intValue();
                    this.agreeData.hasAgree = post.agree.has_agree.intValue() == 1;
                    this.agreeData.agreeNum = this.agreeNum;
                    this.agreeData.disAgreeNum = this.bDn;
                    this.agreeData.diffAgreeNum = post.agree.diff_agree_num == null ? 0L : post.agree.diff_agree_num.longValue();
                } else {
                    this.iGq = false;
                }
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.bDn < 0) {
                    this.bDn = 0L;
                }
                this.iGw = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.bDy = new OriginalThreadInfo();
                    this.bDy.parser(post.origin_thread_info);
                } else {
                    this.bDy = null;
                }
                this.iGz = post.is_fold.intValue();
                this.hkk = post.fold_tip;
                this.iGD = post.is_top_agree_post.intValue() == 1;
                this.iGE = post.show_squared.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int hAY;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(this.hAY));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> iGN;
        private b iGO;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.iGN = new SoftReference<>(context);
            this.iGO = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(d.C0277d.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.iGN != null) {
                if (this.iGO != null) {
                    this.iGO.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.iGN.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String ev(Context context) {
        ArrayList<TbRichTextData> ast;
        if (this.iGa == null || (ast = this.iGa.ast()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = ast.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.asB().toString());
            } else if (next.getType() == 17) {
                String str = next.asF().mGifInfo.mSharpText;
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

    public String ceu() {
        ArrayList<TbRichTextData> ast;
        String str;
        if (this.iGa == null || (ast = this.iGa.ast()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = ast.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.asB().toString());
                } else if (next.getType() == 17) {
                    if (next.asF() != null && next.asF().mGifInfo != null && (str = next.asF().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo cev() {
        ArrayList<TbRichTextData> ast;
        if (this.iGa != null && (ast = this.iGa.ast()) != null) {
            Iterator<TbRichTextData> it = ast.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.asA().getWidth();
                    preLoadImageInfo.height = next.asA().getHeight();
                    preLoadImageInfo.imgUrl = next.asA().asO();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.asG().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.asG().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.asG().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String cew() {
        k cdS;
        PreLoadImageInfo cev = cev();
        if (cev != null && !StringUtils.isNull(cev.imgUrl)) {
            return cev.imgUrl;
        }
        if (this.iGi != null && (cdS = this.iGi.cdS()) != null && !StringUtils.isNull(cdS.cdX())) {
            return cdS.cdX();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> ast;
        if (this.iGa == null || (ast = this.iGa.ast()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = ast.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.asA().getWidth();
                preLoadImageInfo.height = next.asA().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.asA().asT()) {
                    preLoadImageInfo.imgUrl = next.asA().asP();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.asA().asO();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.asF() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.asF().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.asF().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.asF();
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
        if (this.bBJ == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.bBJ.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.iFT == 52) {
            return iFP;
        }
        if (this.iFT == 1) {
            return bCL;
        }
        if (this.iFT == 36) {
            return iFN;
        }
        if (this.iFT == 40 || this.iFT == 50) {
            return bBg;
        }
        if (this.iFT == 41) {
            return iFO;
        }
        if (this.iFT == 53) {
            return iFQ;
        }
        if (cep() == 1) {
            return iFL;
        }
        return iFM;
    }

    public void setPostType(int i) {
        this.iFT = i;
    }

    public ao cex() {
        return this.iGb;
    }

    public void a(ao aoVar) {
        this.iGb = aoVar;
    }

    public i cey() {
        return this.iGi;
    }

    public com.baidu.tbadk.widget.richText.f asE() {
        if (this.iGm != null) {
            return this.iGm;
        }
        if (this.iGa != null && v.S(this.iGa.ast()) > 0) {
            Iterator<TbRichTextData> it = this.iGa.ast().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.iGm = next.asE();
                    return this.iGm;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo asC() {
        if (this.bTp != null) {
            return this.bTp;
        }
        if (this.iGa != null && v.S(this.iGa.ast()) > 0) {
            Iterator<TbRichTextData> it = this.iGa.ast().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.bTp = next.asC();
                    return this.bTp;
                }
            }
        }
        return null;
    }

    public String cez() {
        return this.iGn;
    }

    public String ZQ() {
        return this.bCN;
    }

    public void ZS() {
        if (this.bCj == 0) {
            this.bCj = 1;
        }
    }

    public long aah() {
        return this.agreeNum;
    }

    public long aai() {
        return this.bDn;
    }

    public void af(long j) {
        this.agreeNum = j;
    }

    public boolean beU() {
        return this.hasAgree;
    }

    public void gz(int i) {
        this.bDp = i;
    }

    public void pZ(boolean z) {
        this.hasAgree = z;
    }

    public int aak() {
        return this.bDp;
    }

    public void ag(long j) {
        this.bDn = j;
    }

    public AgreeData aaE() {
        return this.agreeData;
    }

    public OriginalThreadInfo ceA() {
        return this.bDy;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.bDy = originalThreadInfo;
    }

    public int ceB() {
        return this.iGz;
    }

    public String bIe() {
        return this.hkk;
    }

    public boolean ceC() {
        return this.iGE;
    }
}
