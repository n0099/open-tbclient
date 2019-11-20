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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
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
    private String bimg_url;
    private String ccA;
    private SkinInfo ccx;
    private long cda;
    private int cdc;
    private OriginalThreadInfo cdl;
    private TbRichTextVoiceInfo cqI;
    private String hHN;
    private String hIy;
    private SmallTailInfo icf;
    private ArrayList<PostData> jhJ;
    private com.baidu.tbadk.data.c jhQ;
    private com.baidu.tbadk.data.f jhR;
    private i jhU;
    private bd jhV;
    public boolean jhX;
    private com.baidu.tbadk.widget.richText.f jhY;
    private String jhZ;
    private String jia;
    private TPointPost jib;
    public int jif;
    public AlaLiveInfoCoreData jik;
    private boolean jio;
    private boolean jir;
    public an jit;
    public int locate;
    private long tid;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId jhv = BdUniqueId.gen();
    public static final BdUniqueId jhw = BdUniqueId.gen();
    public static final BdUniqueId ccy = BdUniqueId.gen();
    public static final BdUniqueId jhx = BdUniqueId.gen();
    public static final BdUniqueId caR = BdUniqueId.gen();
    public static final BdUniqueId jhy = BdUniqueId.gen();
    public static final BdUniqueId jhz = BdUniqueId.gen();
    public static final BdUniqueId jhA = BdUniqueId.gen();
    public static final BdUniqueId jhB = BdUniqueId.gen();
    public static final BdUniqueId jhC = BdUniqueId.gen();
    public static boolean jhD = false;
    private int jhE = 0;
    private boolean jhK = false;
    private ArrayList<PostData> jhL = null;
    private TbRichText jhM = null;
    private boolean jhP = false;
    private boolean jhS = false;
    private boolean jhT = false;
    public boolean jhW = false;
    public int cbV = 0;
    private boolean jic = false;
    private long agreeNum = 0;
    private boolean hasAgree = false;
    public boolean fCi = false;
    public boolean jie = false;
    public boolean jig = false;
    public boolean jih = true;
    public boolean jii = false;
    public boolean jij = false;
    private boolean jil = false;
    private int jim = 0;
    private boolean jin = true;
    public boolean jip = false;
    public boolean jiq = false;
    public boolean jis = false;
    private b jiu = new b() { // from class: com.baidu.tieba.tbadkCore.data.PostData.1
        @Override // com.baidu.tieba.tbadkCore.data.PostData.b
        public void onClick() {
            if (PostData.this.jit != null) {
                an amH = PostData.this.jit.amH();
                amH.delete("obj_locate");
                amH.O("obj_locate", 7);
                TiebaStatic.log(amH);
            }
        }
    };
    private String id = null;
    private String title = null;
    private int jhF = 0;
    private long time = 0;
    private String date = null;
    private MetaData cbv = new MetaData();
    private ArrayList<l> jhG = new ArrayList<>();
    private ArrayList<l> jhH = new ArrayList<>();
    private int jhI = 0;
    private int ccg = 0;
    private PraiseData cbI = new PraiseData();
    private ao jhN = new ao();
    private c jhO = new c();
    private ArrayList<com.baidu.tbadk.data.c> ccu = new ArrayList<>();
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    private interface b {
        void onClick();
    }

    public PostData() {
        this.jhJ = null;
        this.jif = 0;
        this.jhJ = new ArrayList<>();
        this.jif = 0;
    }

    public void qM(boolean z) {
        this.jio = z;
    }

    public boolean cof() {
        return this.jio;
    }

    public ArrayList<PostData> cog() {
        return this.jhL;
    }

    public void coh() {
        this.jhL.clear();
        this.jhL = null;
        this.jhK = false;
    }

    public void r(PostData postData) {
        if (postData != null) {
            if (this.jhL == null) {
                this.jhL = new ArrayList<>();
                if (v.getCount(this.jhJ) > 2) {
                    this.jhL.addAll(v.subList(this.jhJ, 0, 2));
                } else {
                    this.jhL.addAll(this.jhJ);
                }
            }
            this.jhL.add(postData);
        }
    }

    public void s(PostData postData) {
        if (postData != null && this.jhJ != null) {
            this.jhJ.add(postData);
            col();
        }
    }

    public void DO(String str) {
        if (this.jhL != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.jhL.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.getId())) {
                    this.jhL.remove(next);
                    return;
                }
            }
        }
    }

    public void qN(boolean z) {
        this.jin = z;
    }

    public boolean coi() {
        return this.jin;
    }

    public void qO(boolean z) {
        this.jhK = z;
    }

    public boolean coj() {
        return this.jhK;
    }

    public ArrayList<PostData> cok() {
        return this.jhJ;
    }

    public void col() {
        this.jhI++;
    }

    public void com() {
        this.jhI--;
    }

    public void zP(int i) {
        this.jhI = i;
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

    public String bQr() {
        return this.hHN;
    }

    public int con() {
        return this.jhF;
    }

    public void zQ(int i) {
        this.jhF = i;
    }

    public boolean coo() {
        return this.jhT;
    }

    public void qP(boolean z) {
        this.jhT = z;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = aq.getFormatTime(j);
    }

    public MetaData aiE() {
        return this.cbv;
    }

    public void a(MetaData metaData) {
        this.cbv = metaData;
    }

    public void a(PraiseData praiseData) {
        this.cbI = praiseData;
    }

    public TbRichText cop() {
        return this.jhM;
    }

    public void c(TbRichText tbRichText) {
        this.jhM = tbRichText;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public SmallTailInfo bXD() {
        return this.icf;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.icf = smallTailInfo;
    }

    public com.baidu.tbadk.data.f coq() {
        return this.jhR;
    }

    public SkinInfo aiZ() {
        return this.ccx;
    }

    public void qQ(boolean z) {
        this.jil = z;
    }

    public void a(TbPageContext tbPageContext, boolean z) {
        String str;
        String str2;
        SpannableString spannableString;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        if (tbPageContext != null && this.jhM != null && this.jhM.azf() != null) {
            final BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                if (this.cbv != null && this.cbv.getIs_bawu() == 1) {
                    if (this.jio) {
                        str = " 品牌官";
                    } else if (Config.BAWU_TYPE_MANAGER.equals(this.cbv.getBawu_type())) {
                        str = " 吧主";
                    } else if (Config.BAWU_TYPE_ASSIST.equals(this.cbv.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.cbv.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.cbv.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = aiE().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    final IconData next = it.next();
                    com.baidu.adp.widget.c cVar = new com.baidu.adp.widget.c(new c.a() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2
                        @Override // com.baidu.adp.widget.c.a
                        public Drawable a(final com.baidu.adp.widget.c cVar2) {
                            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) com.baidu.adp.lib.f.c.fT().loadResourceFromMemery(next.getIcon(), 21, new Object[0]);
                            if (aVar == null) {
                                com.baidu.adp.lib.f.c.fT().a(next.getIcon(), 21, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.tbadkCore.data.PostData.2.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    /* JADX INFO: Access modifiers changed from: protected */
                                    @Override // com.baidu.adp.lib.f.b
                                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str4, int i) {
                                        super.onLoaded((AnonymousClass1) aVar2, str4, i);
                                        if (aVar2 != null && aVar2.isValidNow()) {
                                            cVar2.setDrawable(PostData.this.j(aVar2));
                                            PostData.this.jhM.isChanged = true;
                                            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_ADAPTER_CHANGE_CMD));
                                        }
                                    }
                                }, uniqueId);
                            }
                            return PostData.this.j(aVar);
                        }
                    }, 0, 1);
                    cVar.setEmptyBounds(0, 0, TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32), TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.ds32));
                    arrayList.add(cVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (!StringUtils.isNull(this.cbv.getSealPrefix())) {
                sb.append(HanziToPinyin.Token.SEPARATOR);
                sb.append(this.cbv.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(HanziToPinyin.Token.SEPARATOR);
            }
            String sb2 = sb.toString();
            if (this.cbv == null) {
                str2 = null;
                spannableString = new SpannableString(sb2 + str + "：");
                str3 = null;
            } else {
                spannableString = new SpannableString(sb2 + this.cbv.getName_show() + str + "：");
                str2 = this.cbv.getUserName();
                str3 = this.cbv.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            if (!StringUtils.isNull(this.cbv.getSealPrefix())) {
                Bitmap bitmap = am.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                kVar.setOffset(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds2));
                int size = arrayList.size() + this.cbv.getSealPrefix().length() + 1;
                spannableString.setSpan(kVar, size, size + 1, 17);
            }
            spannableString.setSpan(new a(tbPageContext.getPageActivity(), str2, str3, this.jiu), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || (this.cbv != null && this.cbv.getIs_bawu() == 1))) {
                com.baidu.tbadk.core.view.c am = am(z, this.cbv != null && this.cbv.getIs_bawu() == 1);
                if (am != null) {
                    if (this.cbv != null) {
                        int i3 = 0;
                        if (this.cbv.getName_show() != null) {
                            i3 = this.cbv.getName_show().length();
                        }
                        spannableString.setSpan(am, sb2.length() + i3 + 1, i3 + sb2.length() + str.length(), 17);
                    } else {
                        spannableString.setSpan(am, sb2.length(), str.length() + sb2.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> azf = this.jhM.azf();
            if (azf != null && azf.size() > 0) {
                TbRichTextData tbRichTextData2 = azf.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.azo() != null) {
                    if (this.jil) {
                        int indexOf = tbRichTextData2.azo().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.azo().delete(0, indexOf + 1);
                        }
                        this.jil = false;
                    }
                    tbRichTextData2.kN(sb.length());
                    tbRichTextData2.azo().insert(0, (CharSequence) spannableString);
                } else {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= azf.size()) {
                            tbRichTextVoiceInfo = null;
                            break;
                        } else if (azf.get(i5) == null || azf.get(i5).getType() != 512) {
                            i4 = i5 + 1;
                        } else {
                            TbRichTextVoiceInfo azp = azf.get(i5).azp();
                            azf.remove(i5);
                            tbRichTextVoiceInfo = azp;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.a(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.kN(sb.length());
                    tbRichTextData.i(spannableString);
                    azf.add(0, tbRichTextData);
                }
            }
            this.jip = true;
        }
    }

    private com.baidu.tbadk.core.view.c am(boolean z, boolean z2) {
        if (!z && !z2) {
            return null;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds1), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds5), this.jio ? R.color.cp_link_tip_a_alpha50 : R.color.cp_link_tip_a, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds26), this.jio ? R.color.cp_link_tip_a : R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds12), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40));
        if (this.jio) {
            cVar.er(false);
            return cVar;
        }
        cVar.er(true);
        return cVar;
    }

    protected Drawable j(com.baidu.adp.widget.ImageView.a aVar) {
        Bitmap rawBitmap;
        if (aVar == null || (rawBitmap = aVar.getRawBitmap()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36), TbadkCoreApplication.getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(R.dimen.ds36));
        return bitmapDrawable;
    }

    public int cor() {
        return this.jhI;
    }

    public void eb(Context context) {
        int type;
        int i;
        int i2;
        if (this.jhG != null) {
            int i3 = -1;
            int size = this.jhH.size();
            if (size > 0) {
                try {
                    i3 = this.jhH.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.jhG.size()) {
                l lVar = this.jhG.get(i4);
                if (l.cq(i5, lVar.getType())) {
                    this.jhH.get(size - 1).b(lVar.ea(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.jhH.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.ea(context));
                        this.jhH.add(lVar2);
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

    public void ec(Context context) {
        try {
            if (this.jhM != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.jhM.toString());
                if (clipboardManager.getText() != null) {
                }
                return;
            }
            if (this.jhH == null || this.jhH.size() == 0) {
                eb(context);
            }
            ArrayList<l> arrayList = this.jhH;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.cnY() != null) {
                            sb.append((CharSequence) next.cnY());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.getType() == 2) {
                        String pB = TbFaceManager.avr().pB(next.getText());
                        if (pB != null) {
                            sb.append("[");
                            sb.append(pB);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !aq.isEmpty(next.cnX())) {
                        sb.append("[").append(next.cnX()).append("]");
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
                this.jhF = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.jhS = subPostList.is_giftpost.intValue() == 1;
                this.agree = subPostList.agree;
                if (this.agree != null) {
                    this.cdc = this.agree.agree_type.intValue();
                    this.hasAgree = this.agree.has_agree.intValue() == 1;
                    this.agreeNum = this.agree.agree_num.longValue() > 0 ? this.agree.agree_num.longValue() : 0L;
                    this.cda = this.agree.disagree_num.longValue() > 0 ? this.agree.disagree_num.longValue() : 0L;
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
                    this.cbv = metaData;
                }
                if ((this.cbv.getUserId() == null || this.cbv.getUserId().length() <= 0 || this.cbv.getUserId().equals("0")) && metaData2 != null) {
                    this.cbv = metaData2;
                }
                this.jhM = TbRichTextView.a(context, subPostList.content, z);
                if (this.jhM != null) {
                    this.jhM.setPostId(com.baidu.adp.lib.g.b.toLong(this.id, -1L));
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
                this.jhF = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = aq.getFormatTime(this.time);
                this.hHN = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.cbv = metaData;
                }
                this.fCi = post.need_log.intValue() == 1;
                this.jie = post.img_num_abtest.intValue() == 1;
                this.jhV = new bd();
                this.jhV.parserProtobuf(post.from_forum);
                if (this.cbv.getUserId() == null || this.cbv.getUserId().length() <= 0 || this.cbv.getUserId().equals("0")) {
                    this.cbv.parserProtobuf(post.author);
                }
                if (this.cbv != null && context != null) {
                    this.jhZ = this.cbv.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                    this.jia = String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.cbv.getLevel_id()));
                }
                this.jhP = post.is_ntitle.intValue() == 1;
                this.jhI = post.sub_post_number.intValue();
                this.jhU = new i(post.tpoint_post);
                this.jhM = TbRichTextView.a(context, post.content, true);
                if (this.jhM != null) {
                    this.jhM.setPostId(com.baidu.adp.lib.g.b.toLong(this.id, -1L));
                    this.jhM.kM(this.jhF);
                    if (this.cbv != null) {
                        this.jhM.setAuthorId(this.cbv.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            PostData postData = new PostData();
                            postData.jhS = subPostList.is_giftpost.intValue() == 1;
                            postData.agree = subPostList.agree;
                            postData.setUserMap(this.userMap);
                            postData.qM(this.jio);
                            postData.a(subPostList, context);
                            this.jhJ.add(postData);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.jhO.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (post.tail_info != null) {
                    this.jhQ = new com.baidu.tbadk.data.c();
                    this.jhQ.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.jhR = new com.baidu.tbadk.data.f();
                    this.jhR.a(post.lbs_info);
                }
                this.ccg = post.storecount.intValue();
                this.jhN.a(post.present);
                this.cbI.setUserMap(this.userMap);
                this.cbI.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.icf = new SmallTailInfo();
                    this.icf.id = post.signature.signature_id.intValue();
                    this.icf.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.icf.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list2 = this.icf.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list2.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.icf.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.c cVar = new com.baidu.tbadk.data.c();
                        cVar.a(post.ext_tails.get(i2));
                        this.ccu.add(cVar);
                    }
                }
                this.ccx = post.skin_info;
                this.ccA = post.lego_card;
                this.jib = post.tpoint_post;
                if (post.agree != null) {
                    this.jic = true;
                    this.hasAgree = post.agree.has_agree.intValue() == 1;
                    if (post.agree.agree_num.longValue() >= 0) {
                        this.agreeNum = post.agree.agree_num.longValue();
                    } else {
                        this.agreeNum = 0L;
                    }
                    if (post.agree.disagree_num.longValue() >= 0) {
                        this.cda = post.agree.disagree_num.longValue();
                    } else {
                        this.cda = 0L;
                    }
                    this.cdc = post.agree.agree_type.intValue();
                    this.agreeData.postId = this.id;
                    this.agreeData.agreeType = post.agree.agree_type == null ? 0 : post.agree.agree_type.intValue();
                    this.agreeData.hasAgree = post.agree.has_agree.intValue() == 1;
                    this.agreeData.agreeNum = this.agreeNum;
                    this.agreeData.disAgreeNum = this.cda;
                    this.agreeData.diffAgreeNum = post.agree.diff_agree_num == null ? 0L : post.agree.diff_agree_num.longValue();
                } else {
                    this.jic = false;
                }
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.cda < 0) {
                    this.cda = 0L;
                }
                this.jij = post.is_post_visible.intValue() == 1;
                if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                    this.cdl = new OriginalThreadInfo();
                    this.cdl.parser(post.origin_thread_info);
                } else {
                    this.cdl = null;
                }
                this.jim = post.is_fold.intValue();
                this.hIy = post.fold_tip;
                this.jiq = post.is_top_agree_post.intValue() == 1;
                this.jir = post.show_squared.intValue() == 1;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        private int iac;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(this.iac));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> jiA;
        private b jiB;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2, b bVar) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.jiA = new SoftReference<>(context);
            this.jiB = bVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_c));
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.jiA != null) {
                if (this.jiB != null) {
                    this.jiB.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.jiA.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String ed(Context context) {
        ArrayList<TbRichTextData> azf;
        if (this.jhM == null || (azf = this.jhM.azf()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = azf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.azo().toString());
            } else if (next.getType() == 17) {
                String str = next.azs().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(R.string.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(R.string.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(R.string.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public String cos() {
        ArrayList<TbRichTextData> azf;
        String str;
        if (this.jhM == null || (azf = this.jhM.azf()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = azf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.azo().toString());
                } else if (next.getType() == 17) {
                    if (next.azs() != null && next.azs().mGifInfo != null && (str = next.azs().mGifInfo.mSharpText) != null && str.startsWith("#(") && str.endsWith(")")) {
                        sb.append("[" + str.substring(2, str.length() - 1) + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public PreLoadImageInfo cot() {
        ArrayList<TbRichTextData> azf;
        if (this.jhM != null && (azf = this.jhM.azf()) != null) {
            Iterator<TbRichTextData> it = azf.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.azn().getWidth();
                    preLoadImageInfo.height = next.azn().getHeight();
                    preLoadImageInfo.imgUrl = next.azn().azB();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.azt().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.azt().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.azt().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return null;
    }

    public String cou() {
        k cnQ;
        PreLoadImageInfo cot = cot();
        if (cot != null && !StringUtils.isNull(cot.imgUrl)) {
            return cot.imgUrl;
        }
        if (this.jhU != null && (cnQ = this.jhU.cnQ()) != null && !StringUtils.isNull(cnQ.cnV())) {
            return cnQ.cnV();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> azf;
        if (this.jhM == null || (azf = this.jhM.azf()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = azf.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.azn().getWidth();
                preLoadImageInfo.height = next.azn().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.azn().azG()) {
                    preLoadImageInfo.imgUrl = next.azn().azC();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.azn().azB();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.azs() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.azs().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.azs().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.azs();
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
        if (this.cbv == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.cbv.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.jhE == 52) {
            return jhA;
        }
        if (this.jhE == 1) {
            return ccy;
        }
        if (this.jhE == 36) {
            return jhx;
        }
        if (this.jhE == 40 || this.jhE == 50) {
            return caR;
        }
        if (this.jhE == 41) {
            return jhy;
        }
        if (this.jhE == 53) {
            return jhB;
        }
        if (con() == 1) {
            return jhv;
        }
        return jhw;
    }

    public void setPostType(int i) {
        this.jhE = i;
    }

    public ao cov() {
        return this.jhN;
    }

    public void a(ao aoVar) {
        this.jhN = aoVar;
    }

    public i cow() {
        return this.jhU;
    }

    public com.baidu.tbadk.widget.richText.f azr() {
        if (this.jhY != null) {
            return this.jhY;
        }
        if (this.jhM != null && v.getCount(this.jhM.azf()) > 0) {
            Iterator<TbRichTextData> it = this.jhM.azf().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    this.jhY = next.azr();
                    return this.jhY;
                }
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo azp() {
        if (this.cqI != null) {
            return this.cqI;
        }
        if (this.jhM != null && v.getCount(this.jhM.azf()) > 0) {
            Iterator<TbRichTextData> it = this.jhM.azf().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    this.cqI = next.azp();
                    return this.cqI;
                }
            }
        }
        return null;
    }

    public String cox() {
        return this.jhZ;
    }

    public String ajG() {
        return this.ccA;
    }

    public void ajI() {
        if (this.cbV == 0) {
            this.cbV = 1;
        }
    }

    public long ajW() {
        return this.agreeNum;
    }

    public long ajX() {
        return this.cda;
    }

    public void aK(long j) {
        this.agreeNum = j;
    }

    public boolean bmr() {
        return this.hasAgree;
    }

    public void hQ(int i) {
        this.cdc = i;
    }

    public void qR(boolean z) {
        this.hasAgree = z;
    }

    public int ajZ() {
        return this.cdc;
    }

    public void aL(long j) {
        this.cda = j;
    }

    public AgreeData akt() {
        return this.agreeData;
    }

    public OriginalThreadInfo coy() {
        return this.cdl;
    }

    public void g(OriginalThreadInfo originalThreadInfo) {
        this.cdl = originalThreadInfo;
    }

    public int coz() {
        return this.jim;
    }

    public String bQF() {
        return this.hIy;
    }

    public boolean coA() {
        return this.jir;
    }
}
