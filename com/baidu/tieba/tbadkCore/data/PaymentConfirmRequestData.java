package com.baidu.tieba.tbadkCore.data;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class PaymentConfirmRequestData implements Serializable {
    public static final String TERMINAL_ANDROID = "320";
    public static final long serialVersionUID = 5867821330520807722L;
    public long goods_duration;
    public String goods_name;
    public long goods_num;
    public String goods_pic;
    public String goods_unit;
    public int goods_user_level;
    public long open_id;
    public String order_id;
    public int pay_type;
    public long scene_id;
    public long tdou_num;
    public String terminal;

    public long getGoods_duration() {
        return this.goods_duration;
    }

    public String getGoods_name() {
        return this.goods_name;
    }

    public long getGoods_num() {
        return this.goods_num;
    }

    public String getGoods_pic() {
        return this.goods_pic;
    }

    public String getGoods_unit() {
        return this.goods_unit;
    }

    public int getGoods_user_level() {
        return this.goods_user_level;
    }

    public long getOpen_id() {
        return this.open_id;
    }

    public String getOrder_id() {
        return this.order_id;
    }

    public int getPay_type() {
        return this.pay_type;
    }

    public long getScene_id() {
        return this.scene_id;
    }

    public long getTdou_num() {
        return this.tdou_num;
    }

    public String getTerminal() {
        return this.terminal;
    }

    public void setGoods_duration(long j) {
        this.goods_duration = j;
    }

    public void setGoods_name(String str) {
        this.goods_name = str;
    }

    public void setGoods_num(long j) {
        this.goods_num = j;
    }

    public void setGoods_pic(String str) {
        this.goods_pic = str;
    }

    public void setGoods_unit(String str) {
        this.goods_unit = str;
    }

    public void setGoods_user_level(int i) {
        this.goods_user_level = i;
    }

    public void setOpen_id(long j) {
        this.open_id = j;
    }

    public void setOrder_id(String str) {
        this.order_id = str;
    }

    public void setPay_type(int i) {
        this.pay_type = i;
    }

    public void setScene_id(long j) {
        this.scene_id = j;
    }

    public void setTdou_num(long j) {
        this.tdou_num = j;
    }

    public void setTerminal(String str) {
        this.terminal = str;
    }
}
