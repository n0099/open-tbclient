package com.baidu.tieba.tblauncher;

import android.net.Uri;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes9.dex */
public class f {
    public static void C(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM3);
                String queryParameter7 = uri.getQueryParameter("tid");
                String queryParameter8 = uri.getQueryParameter("kw");
                String queryParameter9 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.dAd);
                String queryParameter10 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.dAe);
                String queryParameter11 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.dAf);
                String queryParameter12 = uri.getQueryParameter(com.baidu.tbadk.BdToken.f.dAg);
                String queryParameter13 = uri.getQueryParameter("obj_name");
                String queryParameter14 = uri.getQueryParameter("eqid");
                ao aoVar = new ao("c13561");
                aoVar.dk("obj_locate", queryParameter2);
                aoVar.dk("obj_type", queryParameter3);
                aoVar.dk("obj_param1", queryParameter4);
                aoVar.dk(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aoVar.dk(TiebaInitialize.Params.OBJ_PARAM3, queryParameter6);
                aoVar.dk("tid", queryParameter7);
                aoVar.dk("fname", queryParameter8);
                aoVar.dk(com.baidu.tbadk.BdToken.f.dAd, queryParameter9);
                aoVar.dk(com.baidu.tbadk.BdToken.f.dAe, queryParameter10);
                aoVar.dk(com.baidu.tbadk.BdToken.f.dAf, queryParameter11);
                aoVar.dk(com.baidu.tbadk.BdToken.f.dAg, queryParameter12);
                aoVar.dk("obj_source", queryParameter);
                aoVar.dk("obj_name", queryParameter13);
                aoVar.dk("query", queryParameter14);
                TiebaStatic.log(aoVar);
            }
        }
    }

    public static void D(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "PC".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("kw");
                String queryParameter7 = uri.getQueryParameter("obj_name");
                String queryParameter8 = uri.getQueryParameter("fname");
                ao aoVar = new ao("c13561");
                aoVar.dk("obj_locate", queryParameter2);
                aoVar.dk("obj_type", queryParameter3);
                aoVar.dk("obj_param1", queryParameter4);
                aoVar.dk(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aoVar.dk("fname", queryParameter6);
                aoVar.dk("obj_source", queryParameter);
                aoVar.dk("obj_name", queryParameter7);
                aoVar.dk("fname", queryParameter8);
                TiebaStatic.log(aoVar);
            }
        }
    }

    public static void E(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("kw");
                String queryParameter7 = uri.getQueryParameter("obj_name");
                String queryParameter8 = uri.getQueryParameter("topic_id");
                ao aoVar = new ao("c13561");
                aoVar.dk("obj_locate", queryParameter2);
                aoVar.dk("obj_type", queryParameter3);
                aoVar.dk("obj_param1", queryParameter4);
                aoVar.dk(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aoVar.dk("fname", queryParameter6);
                aoVar.dk("obj_source", queryParameter);
                aoVar.dk("obj_name", queryParameter7);
                aoVar.dk("topic_id", queryParameter8);
                TiebaStatic.log(aoVar);
            }
        }
    }

    public static void F(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("obj_name");
                ao aoVar = new ao("c13561");
                aoVar.dk("obj_locate", queryParameter2);
                aoVar.dk("obj_type", queryParameter3);
                aoVar.dk("obj_param1", queryParameter4);
                aoVar.dk(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aoVar.dk("obj_source", queryParameter);
                aoVar.dk("obj_name", queryParameter6);
                TiebaStatic.log(aoVar);
            }
        }
    }

    public static void G(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "PC".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                uri.getQueryParameter("kw");
                String queryParameter6 = uri.getQueryParameter("obj_name");
                uri.getQueryParameter("fname");
                ao aoVar = new ao("c13561");
                aoVar.dk("obj_locate", queryParameter2);
                aoVar.dk("obj_type", queryParameter3);
                aoVar.dk("obj_param1", queryParameter4);
                aoVar.dk(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                aoVar.dk("obj_source", queryParameter);
                aoVar.dk("obj_name", queryParameter6);
                TiebaStatic.log(aoVar);
            }
        }
    }
}
